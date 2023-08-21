package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.FloorDetails;
import com.canddella.entity.Floor_Slot;
import com.canddella.entity.Slot;
import com.canddella.entity.Vehicle;
import com.canddella.service.Floor_SlotServiceImpl;
import com.canddella.service.VehicleServiceImpl;



public class Floor_SlotUtility {

	public static void main(String[] args) {
		Floor_SlotMenu();

	}

	public static void Floor_SlotMenu() {
        char choice;
		
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.Insert Floor_Slot\n 2.view Floor_Slot\n  3.view all Floor_Slot\n 4.delete Floor_Slot\n  ");
		System.out.println("Enter your choice\n");
		//scanner.nextLine();
		int ch=scanner.nextInt();
		if(ch==1)
		{
			insertFloor_Slot();
		
		}
		else if(ch==2)
		{
			viewFloor_Slot();
		}
		else if(ch==3)
		{
			listallfloor_slot();
		}
		else if(ch==4)
		{
			deleteFloor_Slot();
		}
		
		System.out.println("do yo want to continue");
		choice=scanner.next().charAt(0);
		}while ((choice=='y')||(choice=='Y'));
		
	
}
       

		


		private static void deleteFloor_Slot() {
			Scanner scanner=new Scanner(System.in);
			 System.out.println("enter the Floor_Slot Id");
			 int floor_slotId=scanner.nextInt();
			 Floor_SlotServiceImpl floor_slotServiceImpl = new Floor_SlotServiceImpl();
			 floor_slotServiceImpl.deleteFloor_Slot(floor_slotId);
				
		
	}

		private static void insertFloor_Slot() {
        	 Scanner scanner=new Scanner(System.in);
 			
 			Floor_Slot floor_slot=null;
 			
 			System.out.println("enter the floor_slotid");
 			int floor_slotId=scanner.nextInt();
		
 			FloorDetailsUtility.listAllFloorDetails();
 			System.out.println("enter the floorid");
 			int floorId=scanner.nextInt();
 			FloorDetails floordetails=new FloorDetails();
 			floordetails.setFloorId(floorId);
 			
 			SlotUtility.listAllSlot();
 			System.out.println("enter the slotid");
 			scanner.nextLine();
 			String slotId=scanner.nextLine();
 			Slot slot=new Slot();
 			slot.setSlotId(slotId);
 			
 			
 			floor_slot = new Floor_Slot(floor_slotId,floordetails,slot);
 			
 			
 			Floor_SlotServiceImpl floor_slotServiceImpl = new Floor_SlotServiceImpl();
 			floor_slotServiceImpl.saveFloor_Slot(floor_slot);
 			
	}
		 private static void viewFloor_Slot() {
			 Scanner scanner=new Scanner(System.in);
			 System.out.println("enter the Floor_Slot Id");
			 int floor_slotId=scanner.nextInt();
			 Floor_SlotServiceImpl floor_slotServiceImpl = new Floor_SlotServiceImpl();
			 floor_slotServiceImpl.viewFloor_Slot(floor_slotId);
				
			}
		 public static void listallfloor_slot() {
			 Floor_SlotServiceImpl floor_slotServiceImpl = new Floor_SlotServiceImpl();
			 List<Floor_Slot>floor_slotList=null;
			 floor_slotList=floor_slotServiceImpl.listAllFloor_Slot();
			 
			 System.out.println("+-----------+---------------+------------------+");

			    System.out.printf("| %-9s | %-13s | %-16s | \n",

			            "Floor_Slot Id", "Floor Id", "Slot Id");

			            

			    System.out.println("+-----------+---------------+------------------+");
			    
			 for (Floor_Slot floor_slot : floor_slotList) { 
			 if (floor_slot!=null)
			 
			 {
				 System.out.printf("| %-9s | %-13s | %-16s | \n",
						 
						 floor_slot.getFloor_SlotId(),
						 floor_slot.getFloordetails().getFloorId(),
						 floor_slot.getSlot().getSlotId());
				 
				 System.out.println("+-----------+---------------+------------------+");
				 
						 
					

				    	

				    }
				 }
				
			}

		
		

		
		
}