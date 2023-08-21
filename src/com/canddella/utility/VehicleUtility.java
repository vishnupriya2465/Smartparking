package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.FloorDetails;
import com.canddella.entity.Vehicle;
import com.canddella.service.FloorDetailsServiceImpl;
import com.canddella.service.VehicleServiceImpl;



public class VehicleUtility {

	public static void main(String[] args) {
		VehicleMenu();
}
	

	public static void VehicleMenu() {
    char choice;
		
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.Insert Vehicle\n 2.view vehicle\n 3.delete vehicle\n 4.view all vehicle\n  5.Update vehicle\n ");
		System.out.println("Enter your choice\n");
		//scanner.nextLine();
		int ch=scanner.nextInt();
		if(ch==1)
		{
			insertVehicle();
		
		}
		else if (ch==2)
		{
			viewVehicle();
		}
		else if(ch==3)
		{
			deleteVehicle();
		}
		else if (ch==4)
		{
			listAllVehicle();
		}
		System.out.println("do yo want to continue");
		choice=scanner.next().charAt(0);
	}while ((choice=='y')||(choice=='Y'));
	}

	


	      private static void insertVehicle() {
		  Scanner scanner=new Scanner(System.in);
			
			Vehicle vehicle=null;
			
			System.out.println("enter the vehicleid");
			int vehicleId=scanner.nextInt();
			System.out.println("enter the vehicletype");
			scanner.nextLine();
			String vehicleType =scanner.nextLine();
			CustomerUtility.listAllCustomer();
			System.out.println("enter the customerid");
			int customerId=scanner.nextInt();
			
			Customer customer=new Customer();
			customer.setCustomerId(customerId);
			vehicle = new Vehicle(vehicleId,vehicleType,customer);
			
			
			VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();
			vehicleServiceImpl.saveVehicle(vehicle);
			
		
	}
	private static void viewVehicle() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the Vehicle Id");
		int vehicleId=scanner.nextInt();
		VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();
		vehicleServiceImpl.viewVehicle(vehicleId);
			
		
	}

	private static void deleteVehicle() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the Vehicle Id");
		int vehicleId=scanner.nextInt();
		VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();
		vehicleServiceImpl.deleteVehicle(vehicleId);
	}
	private static void listAllVehicle() {
		VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();
		List<Vehicle>vehicleList=null;
		vehicleList=vehicleServiceImpl.listAllVehicle();
		
		System.out.println("+-----------+---------------+------------------+");

	    System.out.printf("| %-9s | %-13s | %-16s | \n",

	            "Vehicle Id", "Vehicle Type", "Customer Id");

	            

	    System.out.println("+-----------+---------------+------------------+");
	    
		 for (Vehicle vehicle : vehicleList) { 
			 
		 if (vehicle!=null)
			 
			 {
				
		  System.out.printf("| %-9s | %-13s | %-16s | \n",

		  vehicle.getVehicleId(),vehicle.getVehicleType(),vehicle.getCustomer().getCustomerId());
			                   

		   System.out.println("+-----------+---------------+------------------+");
		            

		    	

		    }
		 }
		
	}

}
