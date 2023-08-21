package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.FloorDetails;

public class FloorDAOImpl implements FloorDAO {
//	DataSource ds=DBConnectionPool.getDataSource();


	@Override
	public void saveFloorDetails(FloorDetails floordetails) {
		// TODO Auto-generated method stub
		DataSource ds=DBConnectionPool.getDataSource();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into floor_details(floor_id,floor_number,capacity) values(?,?,?)");
			statement.setInt(1, floordetails.getFloorId());
			statement.setString(2,floordetails.getFloorNumber());
			statement.setInt(3,floordetails.getCapacity());
			
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
	public FloorDetails viewFloorDetails(int floorId) {
		DataSource ds=DBConnectionPool.getDataSource();
		
		FloorDetails floorDetails = null;
		try 

		{
         Connection connection = ds.getConnection();
         PreparedStatement statement=connection.prepareStatement("select * from floor_details where floor_id=?");

			statement.setInt(1, floorId);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next())

				{

					System.out.println("***********************************************************************");	

					System.out.println("Floor Id: - " + resultSet.getString("floor_id") + "\n"

					                 +"floor number: - " + resultSet.getString("floor_number")+ "\n"

					                 + " Capacity: - " +resultSet.getInt("capacity"));

					 System.out.println("***********************************************************************");

						}

				connection.close();

	 }

		catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
		return floorDetails;
	}

	@Override
	public FloorDetails deleteFloorDetails(int floorId) {
		DataSource ds=DBConnectionPool.getDataSource();
		FloorDetails floorDetails = null;
		try

		{

			Connection connection = ds.getConnection();

			PreparedStatement statement =connection.prepareStatement("delete from floor_details where floor_id=?");

			statement.setInt(1, floorId);

			statement.executeUpdate();

			System.out.println(" floor_details deleted successfully");

			}

	catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
		
		return floorDetails;
	}

	@Override
	public List<FloorDetails> listAllFloorDetails() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList<FloorDetails> floordetailsList = new ArrayList<>();

		try

		{

			Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from floor_details");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {
            int floorId = resultSet.getInt("floor_id");
            String floorNumber = resultSet.getString("floor_number");

		    int capacity = resultSet.getInt("capacity"); 

		     FloorDetails floordetails = new FloorDetails(floorId, floorNumber, capacity);

		     floordetailsList.add(floordetails);

		           }

			  
}

		catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
		
		return floordetailsList ;
	}
@Override
	public FloorDetails getFloorDetails(int  floorId) {

	FloorDetails floordetails1 = null;

		DataSource ds=DBConnectionPool.getDataSource();

		

			   try

					{

						Connection connection = ds.getConnection();

						PreparedStatement statement = connection.prepareStatement("select * from floor_details where floor_id = ?");

						statement.setInt(1, floorId);

						ResultSet resultSet=statement.executeQuery();

							 while (resultSet.next()) {

						            int FloorId = resultSet.getInt("floor_id");

						            String floorNumber = resultSet.getString("floor_number");

						            int capacity = resultSet.getInt("capacity"); 

						    floordetails1 = new FloorDetails(FloorId,floorNumber,capacity);

						            			          

						        }								     

							

					}

				catch(Exception e)

					{

						System.out.println(e.getMessage());

					}

		return floordetails1;

	}




@Override

public void updateFloorDetails(int floorId,String floorStore, String floornumber) {



//Venue venue = null;

DataSource ds=DBConnectionPool.getDataSource();



   try

		{

			Connection connection = ds.getConnection();

			PreparedStatement statement = connection.prepareStatement("update floor_details set " + floorStore + " = ? where floor_id = ? ");

			statement.setString(1, floornumber);

			statement.setInt(2, floorId);

			statement.executeUpdate();

												     

				

		}

	catch(Exception e)

		{

			System.out.println(e.getMessage());

		}

}
}

