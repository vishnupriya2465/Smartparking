package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Slot;
import com.canddella.service.SlotServiceImpl;

public class SlotUtility {

	public static void main(String[] args) {
		SlotMenu();
		

	}

	public static void SlotMenu() {
		char choice;
		
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.Insert Slot\n 2.view slot\n 3.delete slot\n 4.view all slot\n 5.Update slot\n ");
		System.out.println("Enter your choice\n");
		//scanner.nextLine();
		int ch=scanner.nextInt();
		if(ch==1)
		{
			insertSlot();
		
		}
		else if (ch==2)
		{
			viewSlot();
		}
		else if (ch==3)
		{
			deleteSlot();
		}
		else if (ch==4)
		{
			listAllSlot();
		}
		else if (ch==5)
		{
			updateslot();
		}
		System.out.println("do yo want to continue");
		choice=scanner.next().charAt(0);
	}while ((choice=='y')||(choice=='Y'));
	}



	private static void insertSlot() {
     Scanner scanner=new Scanner(System.in);
		
		Slot slot=null;
		
		System.out.println("enter the slotid");
		String slotId=scanner.nextLine();
		System.out.println("enter the slotname");
		//scanner.nextLine();
		String slotName=scanner.nextLine();
		
		slot= new Slot(slotId,slotName);
		
		SlotServiceImpl slotServiceImpl = new SlotServiceImpl();
		slotServiceImpl.saveSlot(slot);
		
		
	}
	private static void viewSlot() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the slotId");
		String slotId=scanner.nextLine();
		SlotServiceImpl slotServiceImpl = new SlotServiceImpl();
		slotServiceImpl.viewSlot(slotId);
		
			
		
	}
	private static void deleteSlot() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the slotId");
		String slotId=scanner.nextLine();
		SlotServiceImpl slotServiceImpl = new SlotServiceImpl();
		slotServiceImpl.deleteSlot(slotId);
	}


	public static void listAllSlot() {
		SlotServiceImpl slotServiceImpl = new SlotServiceImpl();
		List<Slot>slotList=null;
		slotList=slotServiceImpl.listAllSlot();
		System.out.println("+-----------+---------------+");

	    System.out.printf("| %-9s | %-13s |  \n",

	            "slot Id", "slot name");

	            

	    System.out.println("+-----------+---------------+");
		 for (Slot slot : slotList) { 
			 if (slot!=null)
			 {
				 System.out.printf("| %-9s | %-13s |  \n",

						 slot.getSlotId (),slot.getSlotName());

			                   

		            System.out.println("+-----------+---------------+");
//			System.out.println("**********************************************************");
//            System.out.println("slot Id: " + slot.getSlotId());
//            System.out.println("slot Name: " + slot.getSlotName());

		        //		        System.out.println("**********************************************************");

		    }
		 }
		
		 }

    private static void updateslot() {
			Scanner scanner=new Scanner(System.in);
	        SlotServiceImpl slotServiceImpl = new SlotServiceImpl ();	
	        System.out.println("Enter the slot id you want to update:");
	        String slotId=scanner.nextLine();
	        Slot slot=slotServiceImpl.getSlot(slotId);
	        char choice = 'y';
	        if(slot!=null)
       
        	 do

			{

			 int ch;
	         System.out.println("1.Slot_Name \n");
	         System.out.println("Enter your choice");
	         ch=scanner.nextInt();
	         String slot_name,newvalue;
	         
	         switch(ch)
{

			case 1:
                slot_name="slot_name";
            System.out.println("Enter the new slot_name");
            scanner.nextLine();
            newvalue=scanner.nextLine();
            slotServiceImpl.updateSlot(slot_name, newvalue,slotId);
            break;
 
			}

			System.out.println("Do you want to continue changing the fields:");
            choice=scanner.next().charAt(0);
            }while((choice=='y')||(choice=='Y'));

		}
	 }


