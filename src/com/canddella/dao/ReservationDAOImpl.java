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
import com.canddella.entity.Floorslot_Availability;
import com.canddella.entity.Reservation;

public class ReservationDAOImpl implements ReservationDAO {

	@Override
	public void saveReservation(Reservation reservation) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into reservation(reservation_id,customer_id,floor_slot_id,reservation_date,reservation_time,start_time,end_time,status) values(?,?,?,?,?,?,?,?)");
			statement.setString(1, reservation.getReservationId());
			statement.setInt(2,reservation.getCustomer().getCustomerId());
			statement.setInt(3,reservation.getFloor_slot().getFloor_SlotId());
			statement.setDate(4,Date.valueOf(reservation.getReservationDate()));
			statement.setTime(5, Time.valueOf(reservation.getReservationTime()));
			statement.setTime(6,Time.valueOf(reservation.getStartTime()));
			statement.setTime(7,Time.valueOf(reservation.getEndTime()));
			statement.setString(8, reservation.getStatus());
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
	    public Reservation viewReservation(String reservationId) {
		DataSource ds=DBConnectionPool.getDataSource();
		
		Reservation reservation = null;
		try 

		{
         Connection connection = ds.getConnection();
         PreparedStatement statement=connection.prepareStatement("select * from reservation where reservation_id=?");

			statement.setString(1, reservationId);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next())

		{

			System.out.println("***********************************************************************");	
            System.out.println("Reservation Id: - " + resultSet.getString("reservation_id") + "\n"
                             +"customer_id: - " + resultSet.getInt("customer_id")+ "\n"
					         +"floor_slot_id:-" + resultSet.getInt("floor_slot_id") +"\n"
					         +"Reservation_date:-"+ resultSet.getDate("reservation_date")+ "\n"
					         +"Reservation Time:-" +  resultSet.getTime("reservation_time")+ "\n"
					         + "Start Time :-"+ resultSet.getTime("start_time")+ "\n"
					         + "End Time :-"+ resultSet.getTime("end_time")+ "\n"
					         + "Status: - " + resultSet.getString("status"));
					         

		    System.out.println("***********************************************************************");
}
            connection.close();

	 }

		     catch(Exception e)

		{

			 System.out.println(e.getMessage());

		}
		return reservation;
	}

	@Override
	public Reservation deleteReservation(String reservationId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Reservation reservation = null;
		try

		{

		 Connection connection = ds.getConnection();
         PreparedStatement statement =connection.prepareStatement("delete from reservation where reservation_id=?");
         statement.setString(1, reservationId);
         statement.executeUpdate();
         System.out.println(" reservation deleted successfully");
}

	    catch(Exception e)

		{
        System.out.println(e.getMessage());

		}
		return reservation;
	}

	@Override
	public List<Reservation> listAllReservation() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList<Reservation> reservationList = new ArrayList<>();

	try

		{

			   Connection connection = ds.getConnection();
	           PreparedStatement statement = connection.prepareStatement("select * from reservation");
	           ResultSet resultSet=statement.executeQuery();
	           while (resultSet.next()) {
	           String reservationId = resultSet.getString("reservation_id");
	           
	           Customer  customer=new  Customer();
               int customerId = resultSet.getInt("customer_id");
               customer.setCustomerId(customerId);
               Floor_Slot  floor_slot=new Floor_Slot();
               int floor_slotId = resultSet.getInt("floor_slot_id");
               floor_slot.setFloor_SlotId(floor_slotId);
               
               Date ReservationDate = resultSet.getDate("reservation_date");
               LocalDate reservationDate = ReservationDate.toLocalDate();
               
               Time reservationTime = resultSet.getTime("reservation_Time");
               LocalTime reservationTime1 = reservationTime.toLocalTime();
	           
               Time startTime = resultSet.getTime("start_Time");
               LocalTime startTime1 = startTime.toLocalTime();
               
               Time endTime = resultSet.getTime("end_Time");
               LocalTime endTime1 = endTime.toLocalTime();
               String status = resultSet.getString("status");
               
               
              Reservation reservation = new Reservation(reservationId,customer,floor_slot,reservationDate,reservationTime1,startTime1,endTime1,status);
               reservationList.add(reservation);
 }

		 }

	          catch(Exception e)
	{
              System.out.println(e.getMessage());

		}
	
		      return reservationList;
	}
	@Override
	public  Floorslot_Availability Totalavailability(Floor_Slot floor_slot) {
	
		 Reservation reservation = new Reservation();
	    DataSource ds = DBConnectionPool.getDataSource();
	    Floorslot_Availability floorslot_Availability = null;
	    ResultSet resultSet = null;
	    System.out.println(floor_slot.getFloor_SlotId());
	    try {
	    	Connection connection    = ds.getConnection();
	    	 PreparedStatement    statement = connection.prepareStatement("SELECT fsa.floor_slot_id, fsa.status FROM floorslot_availability fsa JOIN floor_slot fs ON fsa.floor_slot_id = fs.floor_slot_id WHERE fs.floor_slot_id = ?");
	        statement.setInt(1, floor_slot.getFloor_SlotId());
	        resultSet = statement.executeQuery();
	       
	        if (resultSet.next()) {
	        	System.out.println(resultSet.getString("floor_slot_id"));
	           String id = resultSet.getString("floor_slot_id");
	           floorslot_Availability = new Floorslot_Availability();
	           floorslot_Availability.setFloorslot_AvailabilityId(id);
	          String Status =resultSet.getString("status");
	          floorslot_Availability.setStatus(Status);
	           
	           
	           
	        }
	        else System.out.println("resultSet is empty");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
		return floorslot_Availability;
	    
	    
	  
	}


}

