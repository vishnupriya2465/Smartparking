package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Customer;
import com.canddella.entity.FloorDetails;
import com.canddella.entity.Floor_Slot;
import com.canddella.entity.Reservation;
import com.canddella.entity.Slot;



public class Floor_SlotDAOImpl implements Floor_SlotDAO {

	@Override
	public void saveFloor_Slot(Floor_Slot floor_slot) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into floor_slot(floor_slot_id,floor_id,slot_id) values(?,?,?)");
			statement.setInt(1, floor_slot.getFloor_SlotId());
			
	        statement.setInt(2,floor_slot.getFloordetails().getFloorId());
	        statement.setString(3, floor_slot.getSlot().getSlotId());
			
			
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
	public Floor_Slot viewFloor_Slot(int floor_slotId) {
		DataSource ds=DBConnectionPool.getDataSource();
		
		Floor_Slot floor_slot = null;
		try 

		{
         Connection connection = ds.getConnection();
         PreparedStatement statement=connection.prepareStatement("select * from floor_slot where floor_slot_id=?");
         statement.setInt(1, floor_slotId);
         ResultSet resultSet=statement.executeQuery();
          while(resultSet.next())
{

		 System.out.println("***********************************************************************");	
         System.out.println("Floor_Slot Id: - " + resultSet.getInt("Floor_Slot_id") + "\n"
         +"Floor_id: - " + resultSet.getInt("Floor_id")+ "\n"
		 +"slot_id:-" + resultSet.getString("slot_id"));

		 System.out.println("***********************************************************************");

	}
         connection.close();

	 }
         catch(Exception e)

		{

		  System.out.println(e.getMessage());

		}
		
		   return floor_slot;
	}

	@Override
	public List<Floor_Slot> listAllFloor_Slot() {
		  DataSource ds=DBConnectionPool.getDataSource();
		  ArrayList<Floor_Slot> floor_slotList = new ArrayList<>();

	 try

		{

		  Connection connection = ds.getConnection();
          PreparedStatement statement = connection.prepareStatement("select * from floor_slot");
          ResultSet resultSet=statement.executeQuery();
          while (resultSet.next()) {
        	   
          int floor_slotId = resultSet.getInt("floor_slot_id");
//        String vehicleType = resultSet.getString("vehicle_type");
          FloorDetails  floordetails=new  FloorDetails();
          int floorId = resultSet.getInt("floor_id");
          floordetails.setFloorId(floorId);
          Slot  slot=new  Slot();
          String slotId = resultSet.getString("slot_id");
          slot.setSlotId(slotId);
          
          Floor_Slot floor_slot = new Floor_Slot(floor_slotId, floordetails, slot);
          floor_slotList.add(floor_slot);

	 }

		 }

	     catch(Exception e)

		{

		  System.out.println(e.getMessage());

		}
	
	      return floor_slotList;
	}

	@Override
	public Floor_Slot deleteFloor_Slot(int floor_slotId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Floor_Slot floor_slot = null;
		try

		{

		 Connection connection = ds.getConnection();
         PreparedStatement statement =connection.prepareStatement("delete from floor_slot where floor_slot_id=?");
         statement.setInt(1, floor_slotId);
         statement.executeUpdate();
         System.out.println(" floor_slot deleted successfully");
}

	    catch(Exception e)

		{
        System.out.println(e.getMessage());

		}
		return floor_slot;
	}

}
