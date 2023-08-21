package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.FloorDetails;
import com.canddella.entity.ParkingRate;


public class ParkingRateDAOImpl implements ParkingRateDAO {

	@Override
	public void saveParkingRate(ParkingRate parkingrate) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into parkingrate(rate_id,floor_id,hourly_rate) values(?,?,?)");
			statement.setString(1, parkingrate.getRateId());
			statement.setInt(2,parkingrate.getFloordetails().getFloorId());
			statement.setDouble(3,parkingrate.getHourlyRate());
			
			
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
	public ParkingRate viewParkingRate(String rateId) {
		
			DataSource ds=DBConnectionPool.getDataSource();
			ParkingRate parkingrate = null;
			try 
	
			{
	         Connection connection = ds.getConnection();
	         PreparedStatement statement=connection.prepareStatement("select * from parkingrate where rate_id=?");
	         statement.setString(1, rateId);
	         ResultSet resultSet=statement.executeQuery();
	         while(resultSet.next())
	
		{
	
			 System.out.println("***********************************************************************");	
	
			 System.out.println("Rate Id: - " + resultSet.getString("rate_id") + "\n"
	
						                 +"floor id: - " + resultSet.getInt("floor_id")+ "\n"
						                 +"hourly rate:-" + resultSet.getDouble("hourly_rate"));
	
			 System.out.println("***********************************************************************");
	
		}
	
			 connection.close();
	
		 }
	
			 catch(Exception e)
	
			{
	
			 System.out.println(e.getMessage());
	
			}
			return parkingrate;
	}

	@Override
	public ParkingRate deleteParkingRate(String rateId) {
			DataSource ds=DBConnectionPool.getDataSource();
			ParkingRate parkingrate = null;
			try
	
			{
	
			 Connection connection = ds.getConnection();
	         PreparedStatement statement =connection.prepareStatement("delete from parkingrate where rate_id=?");
	         statement.setString(1, rateId);
	         statement.executeUpdate();
	         System.out.println("parkingrate deleted successfully");
	      }
	         catch(Exception e)
	     {
	         System.out.println(e.getMessage());
	
			}
			 return parkingrate;
	}

	@Override
	public List<ParkingRate> listAllParkingRate() {
			DataSource ds=DBConnectionPool.getDataSource();
			ArrayList<ParkingRate>parkingrateList = new ArrayList<>();

			try

		{

			Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from parkingrate");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {
        	String rateId = resultSet.getString("rate_id");
            
            FloorDetails  floordetails=new FloorDetails();
            int floorId = resultSet.getInt("floor_id");
            floordetails.setFloorId(floorId);
            Double hourlyRate=resultSet.getDouble("hourly_rate");

	        ParkingRate parkingrate = new ParkingRate(rateId,floordetails,hourlyRate);
            parkingrateList.add(parkingrate);
        }

		 }

	        catch(Exception e)

		{

		    System.out.println(e.getMessage());

		}
	
		    return parkingrateList;
	}

	

}
