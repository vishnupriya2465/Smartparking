package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Floor_Slot;
import com.canddella.entity.Floorslot_Availability;





public class Floorslot_AvailabilityDAOImpl implements Floorslot_AvailabilityDAO {

	@Override
	public void saveFloorslot_Availability(Floorslot_Availability floorslot_Availability) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into floorslot_Availability(floorslot_availability_id,floor_slot_id,status) values(?,?,?)");
			statement.setString(1, floorslot_Availability.getFloorslot_AvailabilityId());
			statement.setInt(2,floorslot_Availability.getFloor_slot().getFloor_SlotId());
			statement.setString(3, floorslot_Availability.getStatus());
			
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
	public Floorslot_Availability viewFloorslot_Availability(String floorslot_AvailabilityId) {
		 DataSource ds=DBConnectionPool.getDataSource();
			
		 Floorslot_Availability  floorslot_Availability = null;
			try 

			{
	         Connection connection = ds.getConnection();
	         PreparedStatement statement=connection.prepareStatement("select * from floorslot_Availability where floorslot_Availability_id=?");

			 statement.setString(1, floorslot_AvailabilityId);
	         ResultSet resultSet=statement.executeQuery();
	         while(resultSet.next())

	{

			 System.out.println("***********************************************************************");	

			 System.out.println("Floorslot_Availability  Id: - " + resultSet.getString("floorslot_Availability_id") + "\n"
					 
                              +"floor_slot_id:-" + resultSet.getInt("floor_slot_id")+ "\n"
						     +"status: - " + resultSet.getString("status")+ "\n"
						     +"status: -"+ resultSet.getInt("total_availability"));
						       
			  System.out.println("***********************************************************************");

	}

			 connection.close();

		 }

			catch(Exception e)

			{

				System.out.println(e.getMessage());

			}
			return floorslot_Availability;
	}

	@Override
	public Floorslot_Availability deleteFloorslot_Availability(String floorslot_AvailabilityId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Floorslot_Availability floorslot_Availability = null;
		try

		{

			Connection connection = ds.getConnection();

			PreparedStatement statement =connection.prepareStatement("delete from floorslot_Availability where floorslot_Availability_id=?");

			statement.setString(1, floorslot_AvailabilityId);

			statement.executeUpdate();

			System.out.println(" floorslot_Availability deleted successfully");

			}

	catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
		
		return floorslot_Availability;
	}

	@Override
	public List<Floorslot_Availability> listAllFloorslot_Availability() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList<Floorslot_Availability>floorslot_AvailabilityList = new ArrayList<>();

	try

		{

			Connection connection = ds.getConnection();
           PreparedStatement statement = connection.prepareStatement("select * from floorslot_Availability");
           ResultSet resultSet=statement.executeQuery();
           while (resultSet.next()) {
        	   
        	   
          String floorslot_AvailabilityId = resultSet.getString("floorslot_Availability_id");
           int floor_slot_Id=resultSet.getInt("Floor_Slot_id");
           Floor_Slot  floor_slot=new  Floor_Slot();
           floor_slot.setFloor_SlotId(floor_slot_Id);
           //int floor_slot_Id = resultSet.getInt("Floor_Slot_id"); 
           //floor_slot.setFloor_SlotId(floor_slot_Id);
           String status = resultSet.getString("status");
           
           
           

           Floorslot_Availability floorslot_Availability = new Floorslot_Availability( floorslot_AvailabilityId, floor_slot, status);

           floorslot_AvailabilityList.add(floorslot_Availability);

	           }

		 }

	catch(Exception e)

		{

		System.out.println(e.getMessage());

		}
	
	return floorslot_AvailabilityList;
		
	}
	
}
