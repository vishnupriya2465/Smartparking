package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void saveCustomer(Customer customer) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into customer(customer_id,customer_firstname,customer_lastname,customer_phone_number,customer_address) values(?,?,?,?,?)");
			statement.setInt(1, customer.getCustomerId());
			statement.setString(2,customer.getCustomerFirstname());
			statement.setString(3,customer.getCustomerLastname());
			statement.setString(4,customer.getCustomerPhoneNumber());
			statement.setString(5,customer.getCustomerAddress());
			
			
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
	public Customer viewCustomer(int customerId) {
DataSource ds=DBConnectionPool.getDataSource();
		
		Customer customer = null;
		try 

		{
         Connection connection = ds.getConnection();
         PreparedStatement statement=connection.prepareStatement("select * from customer where customer_id=?");

			statement.setInt(1, customerId);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next())

				{

					System.out.println("***********************************************************************");	

					System.out.println("customer Id: - " + resultSet.getInt("customer_id") + "\n"

					                 +"customer firstname: - " + resultSet.getString("customer_firstname")+ "\n"

					                 + "customer lastname: - " +resultSet.getString("customer_lastname")+ "\n"
					                 + "customer phone number: -" +resultSet.getString("customer_phone_number")+ "\n"
					                 + "customer address:-" +resultSet.getString("customer_address"));
					                 

					 System.out.println("***********************************************************************");

						}

				connection.close();

	 }

		catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
		return customer;
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Customer customer = null;
		try

		{

			Connection connection = ds.getConnection();

			PreparedStatement statement =connection.prepareStatement("delete from customer where customer_id=?");

			statement.setInt(1, customerId);

			statement.executeUpdate();

			System.out.println(" customer deleted successfully");

			}

	catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		return customer;
	}

	@Override
	public List<Customer> listAllCustomer() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList<Customer> customerList = new ArrayList<>();

		try

		{

			Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from customer");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {
            int customerId = resultSet.getInt("customer_id");
            String customerFirstname = resultSet.getString("customer_firstname");
            String customerLastname = resultSet.getString("customer_lastname");
		    String customerPhoneNumber = resultSet.getString("customer_phone_number");
		    String customerAddress = resultSet.getString("customer_address");
		    

		     Customer customer = new Customer(customerId, customerFirstname,customerLastname,customerPhoneNumber, customerAddress);

		    customerList.add(customer);

		           }
}
             catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
		    return customerList;
	}

	
	
	}



	


