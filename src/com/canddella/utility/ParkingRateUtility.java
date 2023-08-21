package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.FloorDetails;
import com.canddella.entity.ParkingRate;
import com.canddella.entity.Vehicle;
import com.canddella.service.ParkingRateServiceImpl;
import com.canddella.service.VehicleServiceImpl;

public class ParkingRateUtility {

	public static void main(String[] args) {
		ParkingRatetMenu();

	}

	public static void ParkingRatetMenu() {
       char choice;
		
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.Insert ParkingRate\n 2.view ParkingRate\n 3.delete ParkingRate\n 4.view allParkingRate\n  ");
		System.out.println("Enter your choice\n");
		//scanner.nextLine();
		int ch=scanner.nextInt();
		if(ch==1)
		{
			insertParkingRate();
		
		}
		else if(ch==2)
		{
			viewParkingRate();
		}
		else if(ch==3)
		{
			deleteParkingRate();
		}
		else if(ch==4)
		{
			viewallParkingRate();
		}
		System.out.println("do yo want to continue");
		choice=scanner.next().charAt(0);
	}    while ((choice=='y')||(choice=='Y'));
	}

	
	

	private static void insertParkingRate() {
		Scanner scanner=new Scanner(System.in);
		
		ParkingRate parkingrate=null;
		
		System.out.println("enter the rateid");
		String rateId=scanner.nextLine();
		
		FloorDetailsUtility.listAllFloorDetails();
		System.out.println("enter the floorid");
		int floorId=scanner.nextInt();
		
		FloorDetails floordetails=new FloorDetails();
		floordetails.setFloorId(floorId);
		
		System.out.println("enter the hourly rate");
		scanner.nextLine();
		Double hourlyrate =scanner.nextDouble();
		
		parkingrate = new ParkingRate(rateId,floordetails,hourlyrate);
		
		
		ParkingRateServiceImpl parkingrateServiceImpl = new ParkingRateServiceImpl();
		parkingrateServiceImpl.saveParkingRate(parkingrate);
		
		
	}
	private static void viewParkingRate() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the Rate Id");
		String rateId=scanner.nextLine();
		ParkingRateServiceImpl parkingrateServiceImpl = new ParkingRateServiceImpl();
		parkingrateServiceImpl.viewParkingRate(rateId);
		
	}
	private static void deleteParkingRate() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the Rate Id");
		String rateId=scanner.nextLine();
		ParkingRateServiceImpl parkingrateServiceImpl = new ParkingRateServiceImpl();
		parkingrateServiceImpl.deleteParkingRate(rateId);
		
	}
	private static void viewallParkingRate() {
			ParkingRateServiceImpl parkingrateServiceImpl = new ParkingRateServiceImpl();
			List<ParkingRate>parkingrateList=null;
			parkingrateList=parkingrateServiceImpl.listAllParkingRate();
		
		  System.out.println("+-----------+---------------+------------------+");

	      System.out.printf("| %-9s | %-13s | %-16s | \n",

	            "Rate Id", "Floor Id", "Hourly rate");

	            

	      System.out.println("+-----------+---------------+------------------+");
	    
		  for (ParkingRate parkingrate : parkingrateList) { 
			 
		   if (parkingrate!=null)
				
	 {
		   System.out.printf("| %-9s | %-13s | %-16s | \n",

		   parkingrate.getRateId(),parkingrate.getFloordetails().getFloorId(), parkingrate.getHourlyRate());


		   System.out.println("+-----------+---------------+------------------+");
			

		    	
		    }
		 }
		
	}

	}

	


