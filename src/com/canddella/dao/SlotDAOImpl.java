package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.FloorDetails;
import com.canddella.entity.Slot;

public class SlotDAOImpl implements SlotDAO {
	//DataSource ds=DBConnectionPool.getDataSource();
	

	@Override
	public void saveSlot(Slot slot) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into slot(slot_id,slot_name) values(?,?)");
			statement.setString(1, slot.getSlotId());
			statement.setString(2,slot.getSlotName());
			
			
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
	public Slot viewSlot(String slotId) {
    DataSource ds=DBConnectionPool.getDataSource();
		
		Slot slot = null;
		try 

		{
         Connection connection = ds.getConnection();
         PreparedStatement statement=connection.prepareStatement("select * from slot where slot_id=?");

			statement.setString(1, slotId);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next())

				{

					System.out.println("***********************************************************************");	

					System.out.println("Slot Id: - " + resultSet.getString("slot_id") + "\n"

					                 +"slot name: - " + resultSet.getString("slot_name"));

					                

					 System.out.println("***********************************************************************");

						}

				connection.close();

	 }

		catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
	return slot;
	}


	@Override
	public Slot deleteSlot(String slotId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Slot slot = null;
		try

		{

			Connection connection = ds.getConnection();

			PreparedStatement statement =connection.prepareStatement("delete from slot where slot_id=?");

			statement.setString(1, slotId);

			statement.executeUpdate();

			System.out.println(" slot deleted successfully");

			}

	catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
		
		return slot;
	}


	@Override
	public List<Slot> listAllSlot() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList<Slot> slotList = new ArrayList<>();

		try

		{

			Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from slot");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {
            String slotId = resultSet.getString("slot_id");
            String slotName = resultSet.getString("slot_name");

            Slot slot = new Slot(slotId, slotName);
            slotList.add(slot);

		     }

			  
}
catch(Exception e)

		{

			System.out.println(e.getMessage());

		}
		
		
		return slotList;
	}


	
		@Override
	public void updateSlot(String slotName,String newValue, String slotId) {
		DataSource ds = DBConnectionPool.getDataSource();

		//College college = null;

		try {
        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("update slot set "+ slotName +" = ? where slot_id=?");
        statement.setString(1,newValue);
        statement.setString(2,slotId);
        statement.executeUpdate();
        int count = 0;
        count = statement.executeUpdate();
        if (count > 0) {
        System.out.println("Updated Successfully");
}
        connection.close();

} catch (Exception e) {

		System.out.println(e.getMessage());

		}

		
}
	@Override
	public Slot getSlot(String slotId) {
		DataSource ds = DBConnectionPool.getDataSource();

		Slot slot = null;

		
try {

		 Connection connection = ds.getConnection();
         PreparedStatement statement = connection.prepareStatement("select  * from slot where slot_id=?");
         statement.setString(1,slotId);
         ResultSet resultSet = statement.executeQuery();
         while (resultSet.next()) {
         String slotId1 = resultSet.getString("slot_id");
         String slotName = resultSet.getString("slot_name");
        
         slot = new Slot(slotId1, slotName);
//       collegeList.add(college);

			}
         connection.close();
        } catch (Exception e) {

		System.out.println(e.getMessage());

		}

     return slot;

	}

}

	

	
	


