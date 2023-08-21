package com.canddella.utility;

import java.util.Scanner;

import com.canddella.entity.FloorDetails;
import com.canddella.service.FloorDetailsServiceImpl;
import java.util.List;

public class FloorDetailsUtility {

	public static void main(String[] args) {
		FloorDetailsMenu();
		
	}

	public static void FloorDetailsMenu() {
		char choice;
		
 // 	Scanner scanner=new Scanner(System.in);
 // 	scanner.nextLine();
	
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.InsertFloordetails\n 2.view floordetails\n 3.delete floordetails\n 4.view all floordetails\n 5.updatefloordetails");
		System.out.println("Enter your choice\n");
		int ch=scanner.nextInt();
		if(ch==1)
		{
			insertFloorDetails();
		
		}
		else if (ch==2)
		{
			viewFloorDetails();
		
		}
		else if (ch==3)
		{
			deleteFloorDetails();
		}
		else if (ch==4)
		{
			listAllFloorDetails();
		}
		else if(ch==5)
		{
			updateFloorDetails();
		}
		System.out.println("do yo want to continue");
		choice=scanner.next().charAt(0);
	}while ((choice=='y')||(choice=='Y'));
}


	


	private static void insertFloorDetails() {
		Scanner scanner=new Scanner(System.in);
		
		FloorDetails floordetails=null;
		
		System.out.println("enter the Floorid");
		int floorId=scanner.nextInt();
		//scanner.nextInt();
		System.out.println("enter the FloorNumber");
		scanner.nextLine();
		String floorNumber=scanner.nextLine();
		
		System.out.println("enter the capacity");
		int capacity=scanner.nextInt();
		floordetails= new FloorDetails(floorId,floorNumber,capacity);
		
		FloorDetailsServiceImpl floorDetailsServiceImpl = new FloorDetailsServiceImpl();
		floorDetailsServiceImpl.saveFloorDetails(floordetails);
		
	}
private static void viewFloorDetails() {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter the FloorId");
	int floorId=scanner.nextInt();
	FloorDetailsServiceImpl floorDetailsServiceImpl = new FloorDetailsServiceImpl();
	floorDetailsServiceImpl.viewFloorDetails(floorId);
		
		
	}
private static void deleteFloorDetails() {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter the FloorId");
	int floorId=scanner.nextInt();
	FloorDetailsServiceImpl floorDetailsServiceImpl = new FloorDetailsServiceImpl();
	floorDetailsServiceImpl.deleteFloorDetails(floorId);
	
}

  public static void listAllFloorDetails() {
	FloorDetailsServiceImpl floorDetailsServiceImpl = new FloorDetailsServiceImpl();
	List<FloorDetails>floordetailsList=null;
	floordetailsList=floorDetailsServiceImpl.listAllFloorDetails();
	
	System.out.println("+-----------+---------------+------------------+");

    System.out.printf("| %-9s | %-13s | %-16s | \n",

            "Floor Id", "Floor Number", "Capacity");

            

    System.out.println("+-----------+---------------+------------------+");
	 for (FloorDetails floordetails : floordetailsList) { 
		 if (floordetails!=null)
		 {
	            System.out.printf("| %-9s | %-13s | %-16s | \n",

	                floordetails.getFloorId(),floordetails.getFloorNumber(), floordetails.getCapacity());

	                   

            System.out.println("+-----------+---------------+------------------+");
		
//
//	    	System.out.println("**********************************************************");
//
//	        System.out.println("Floor Id: " + floordetails.getFloorId());
//
//	        System.out.println("Floor Number: " + floordetails.getFloorNumber());
//
//	        System.out.println("capacity: " + floordetails.getCapacity());

//	        System.out.println("**********************************************************");

	    }
	 }
}
	
	

	private static void updateFloorDetails() {
		Scanner scanner=new Scanner(System.in);
		FloorDetailsServiceImpl floorDetailsServiceImpl = new FloorDetailsServiceImpl();
		System.out.println("enter the FloorId");
		int floorId =scanner.nextInt();
		FloorDetails  floordetails=floorDetailsServiceImpl.getFloorDetails(floorId);
		char choice ='y';
		if (floordetails!=null)
			
			
			do
				
		{
			int ch;
			System.out.println("1.floor number\n 2.capacity");
			ch=scanner.nextInt();
			String floorStore;
			switch(ch)
			{
			case 1 : floorStore = "Floor_number";

            System.out.println("Enter the New floor number");
            scanner.nextLine(); // Consume the newline character

            String floornumber = scanner.nextLine();

            floorDetailsServiceImpl.updateFloorDetails(floorId, floorStore, floornumber);

            break;

        case 2:				   

            floorStore = "capacity";

            System.out.println("Enter the New  Capacity");

            scanner.nextLine(); // Consume the newline character

            int Capacity = scanner.nextInt();

            floorDetailsServiceImpl.updateFloorDetails(floorId, floorStore, String.valueOf(Capacity));

            break;
			
			
			
			}
					System.out.println("Do you want to continue changing the fields:");

		choice=scanner.next().charAt(0);

	}while((choice=='y')||(choice=='Y'));

	

}
		
	}
	

	


