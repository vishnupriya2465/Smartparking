package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Customer;
import com.canddella.entity.Floor_Slot;
import com.canddella.entity.Payment;
import com.canddella.entity.Reservation;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public void savePayment(Payment payment) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into payment(payment_id,customer_id,reservation_id,payment_time,payment_date,amount) values(?,?,?,?,?,?)");
			statement.setString(1, payment.getPaymentId());
			statement.setInt(2,payment.getCustomer().getCustomerId());
			statement.setString(3,payment.getReservation().getReservationId());
			statement.setTime(4, Time.valueOf(payment.getPaymentTime()));
			statement.setDate(5,Date.valueOf(payment.getPaymentDate()));
			statement.setDouble(6, payment.getAmount());
			int count=0;
			count=statement.executeUpdate();
			if(count>0)
			{
				System.out.println("Updated Successfully");
			}
			connection.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	  public Payment viewPayment(String paymentId) {
       DataSource ds=DBConnectionPool.getDataSource();
		
        Payment payment = null;
		try 

		{
         Connection connection = ds.getConnection();
         PreparedStatement statement=connection.prepareStatement("select * from payment where payment_id=?");

			statement.setString(1, paymentId);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next())

		{

			System.out.println("***********************************************************************");	
            System.out.println("payment Id: - " + resultSet.getString("payment_id") + "\n"
                             +"customer_id: - " + resultSet.getInt("customer_id")+ "\n"
                             +"reservation_id: - " + resultSet.getString("reservation_id")+ "\n"
                             +"payment_Time:-" +  resultSet.getTime("payment_time")+ "\n"
					         +"payment_date:-"+ resultSet.getDate("payment_date")+ "\n"
					         
					        
					         + "amount: - " + resultSet.getDouble("amount"));
					         

		    System.out.println("***********************************************************************");
}
            connection.close();

	 }

		     catch(Exception e)

		{

			 System.out.println(e.getMessage());

		}
		return payment;
	}

	@Override
	public Payment deletePayment(String paymentId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Payment payment = null;
		try

		{

		 Connection connection = ds.getConnection();
         PreparedStatement statement =connection.prepareStatement("delete from Payment where payment_id=?");
         statement.setString(1, paymentId);
         statement.executeUpdate();
         System.out.println(" payment deleted successfully");
}

	    catch(Exception e)

		{
        System.out.println(e.getMessage());

		}
		return payment;
	}

	@Override
	    public List<Payment> listAllPayment() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList<Payment> paymentList = new ArrayList<>();

	   try

		{

			   Connection connection = ds.getConnection();
	           PreparedStatement statement = connection.prepareStatement("select * from payment");
	           ResultSet resultSet=statement.executeQuery();
	           while (resultSet.next()) {
	           String paymentId = resultSet.getString("payment_id");
	           
	           Customer  customer=new  Customer();
               int customerId = resultSet.getInt("customer_id");
               customer.setCustomerId(customerId);
               Reservation  reservation=new Reservation();
               String reservation_Id = resultSet.getString("reservation_id");
               reservation.setReservationId(reservation_Id);
               
              
               
               Time paymentTime = resultSet.getTime("payment_Time");
               LocalTime paymentTime1 = paymentTime.toLocalTime();
               
               Date PaymentDate = resultSet.getDate("payment_date");
               LocalDate paymentDate = PaymentDate.toLocalDate();
	           
              
               Double amount = resultSet.getDouble("amount");
               
               
               Payment payment = new Payment(paymentId,customer,reservation,paymentTime1,paymentDate,amount);
               paymentList.add(payment);
 }

		 }

	          catch(Exception e)
	{
              System.out.println(e.getMessage());

		}
	
		return paymentList;
	}

}
