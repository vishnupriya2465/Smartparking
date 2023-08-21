package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Floor_Slot;
import com.canddella.entity.Floorslot_Availability;
import com.canddella.entity.Vehicle;
import com.canddella.service.Floorslot_AvailabilityServiceImpl;
import com.canddella.service.VehicleServiceImpl;


public class Floorslot_AvailabilityUtility {

	public static void main(String[] args) {
		 Floorslot_AvailabilityMenu();
	}

	public static void Floorslot_AvailabilityMenu() {
		 char choice;
			
			do
			{
			Scanner scanner=new Scanner(System.in);
			System.out.println("1.Insert Floorslot_Availability\n 2.view Floorslot_Availability\n 3.deleteFloorslot_Availability\n 4.view all Floorslot_Availability\n  ");
			System.out.println("Enter your choice\n");
			//scanner.nextLine();
			int ch=scanner.nextInt();
			if(ch==1)
			{
				insertFloorslot_Availability();
			
			}
			else if(ch==2)
			{
				viewFloorslot_Availability();
			}
			else if(ch==3)
			{
				deleteFloorslot_Availability();
			}
			else if(ch==4)
			{
				listAllFloorslot_Availability();
			}
			System.out.println("do yo want to continue");
			scanner.nextLine();
			choice=scanner.next().charAt(0);
		}   while ((choice=='y')||(choice=='Y'));

}

	


	

	private static void insertFloorslot_Availability() {
		 Scanner scanner=new Scanner(System.in);
			
		    Floorslot_Availability floorslot_Availability=null;
			
			System.out.println("enter the floorslot_Availabilityid");
			String floorslot_AvailabilityId=scanner.nextLine();
			
			Floor_SlotUtility.listallfloor_slot();
			System.out.println("enter the floor_slot_id");
			int floor_slotId=scanner.nextInt();
			
			Floor_Slot floor_slot=new Floor_Slot();
			floor_slot.setFloor_SlotId(floor_slotId);
			
			System.out.println("enter the status");
			scanner.nextLine();
			String status =scanner.nextLine();
			
			
			
			floorslot_Availability = new Floorslot_Availability(floorslot_AvailabilityId,floor_slot,status);
			
			
			Floorslot_AvailabilityServiceImpl floorslot_AvailabilityServiceImpl = new Floorslot_AvailabilityServiceImpl();
			floorslot_AvailabilityServiceImpl.saveFloorslot_Availability(floorslot_Availability);
			
		
		
	}
	private static void viewFloorslot_Availability() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the floorslot_Availability Id");
		String floorslot_AvailabilityId=scanner.nextLine();
		Floorslot_AvailabilityServiceImpl floorslot_AvailabilityServiceImpl = new Floorslot_AvailabilityServiceImpl();
		floorslot_AvailabilityServiceImpl.viewFloorslot_Availability(floorslot_AvailabilityId);
		
	}
	private static void deleteFloorslot_Availability() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the Floorslot_Availability Id");
		String floorslot_AvailabilityId=scanner.nextLine();
		Floorslot_AvailabilityServiceImpl floorslot_AvailabilityServiceImpl = new Floorslot_AvailabilityServiceImpl();
		floorslot_AvailabilityServiceImpl.deleteFloorslot_Availability(floorslot_AvailabilityId);
		
	}
	private static void listAllFloorslot_Availability() {
		Floorslot_AvailabilityServiceImpl floorslot_AvailabilityServiceImpl = new Floorslot_AvailabilityServiceImpl();
		List<Floorslot_Availability>floorslot_AvailabilityList=null;
		floorslot_AvailabilityList=floorslot_AvailabilityServiceImpl.listAllFloorslot_Availability();
		
		 System.out.println("+------------------------+---------------------+----------------+");

		    System.out.printf("| %-23s| %-19s| %-16s|\n",

		            "Floorlot_AvailabilityId", "Floor_slot Id", "status");

		            

		    System.out.println("+------------------------+---------------------+-----------------+");
		    
		 for (Floorslot_Availability floorslot_Availability : floorslot_AvailabilityList) { 
			 if (floorslot_Availability!=null)
			 {
				 System.out.printf("| %-23s| %-19s| %-16s|\n",
						 floorslot_Availability.getFloorslot_AvailabilityId(),
						 floorslot_Availability.getFloor_slot().getFloor_SlotId(),
						 floorslot_Availability.getStatus());
						 
				 System.out.println("+------------------------+---------------------+-----------------+");
						 
			

	   
		    }
		 }
		
	}
}