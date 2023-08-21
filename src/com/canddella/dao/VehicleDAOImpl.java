package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Customer;
import com.canddella.entity.Vehicle;

public class VehicleDAOImpl implements VehicleDAO {

	@Override
	public void saveVehicle(Vehicle vehicle) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into vehicle(vehicle_id,vehicle_type,customer_id) values(?,?,?)");
			statement.setInt(1, vehicle.getVehicleId());
			statement.setString(2,vehicle.getVehicleType());
			statement.setInt(3,vehicle.getCustomer().getCustomerId());
			
			
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
	public Vehicle viewVehicle(int vehicleId) {
	    DataSource ds=DBConnectionPool.getDataSource();
		
			Vehicle vehicle = null;
			try 

			{
	         Connection connection = ds.getConnection();
	         PreparedStatement statement=connection.prepareStatement("select * from vehicle where vehicle_id=?");

				statement.setInt(1, vehicleId);
	            ResultSet resultSet=statement.executeQuery();
	            while(resultSet.next())

					{

						System.out.println("***********************************************************************");	

						System.out.println("Vehicle Id: - " + resultSet.getInt("vehicle_id") + "\n"

						                 +"vehicke type: - " + resultSet.getString("vehicle_type")+ "\n"
						                 +"customer_id:-" + resultSet.getInt("customer_id"));

						                

						 System.out.println("***********************************************************************");

							}

					connection.close();

		 }

			catch(Exception e)

			{

				System.out.println(e.getMessage());

			}
			
		return vehicle;
	}

	

	@Override
	public Vehicle deleteVehicle(int vehicleId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Vehicle vehicle = null;
		try

		{

			Connection connection = ds.getConnection();

			PreparedStatement statement =connection.prepareStatement("delete from vehicle where vehicle_id=?");

			statement.setInt(1, vehicleId);

			statement.executeUpdate();

			System.out.println(" vehicle deleted successfully");

			}

	catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
		return vehicle;
	}

	

	@Override
	public List<Vehicle> listAllVehicle() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList<Vehicle> vehicleList = new ArrayList<>();

	try

		{

			Connection connection = ds.getConnection();
           PreparedStatement statement = connection.prepareStatement("select * from vehicle");
           ResultSet resultSet=statement.executeQuery();
           while (resultSet.next()) {
        	   
        	   
           int vehicleId = resultSet.getInt("vehicle_id");
           
           
           String vehicleType = resultSet.getString("vehicle_type");
           
           Customer  customer=new  Customer();
           int customerId = resultSet.getInt("customer_id"); 
           customer.setCustomerId(customerId);

	       Vehicle vehicle = new Vehicle(vehicleId, vehicleType, customer);

	       vehicleList.add(vehicle);

	           }

		 }

	        catch(Exception e)

		{

		     System.out.println(e.getMessage());

		}
	
	         return vehicleList;
	}
	}

