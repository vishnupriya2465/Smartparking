package com.canddella.utility;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

		    int ch;

		    char option;

		    

		    do {

	   System.out.println("1.FloorDetails     \n"
	                    
			            + "2.Slot  \n"

		    			+ "3.Floor_Slot \n"

		    			+ "4.Floorslot_Availability    \n"

		    			+ "5.Customer \n"

		    			+ "6.Vehicle \n"

		    			+ "7.Reservation \n" 
		    			
		    			+ "8.ParkingRate \n"
		    			
		    			+ "9.Payment ");

		    			

		    	System.out.println("Enter your choice");

		    	ch = scanner.nextInt();

		    	switch(ch)

		    	 {

			    	case 1 :  FloorDetailsUtility.FloorDetailsMenu();;

			    	break;

			    	case 2:   SlotUtility.SlotMenu();

			    	break;

			    	case 3 :  Floor_SlotUtility.Floor_SlotMenu();

			    	break;

			    	case 4 :  Floorslot_AvailabilityUtility.Floorslot_AvailabilityMenu();

			    	break;

			    	case 5 :  CustomerUtility.CustomerMenu();

			    	break;

			    	case 6 :  VehicleUtility.VehicleMenu();

			    	break;

			    	case 7:   ReservationUtility.ReservationMenu();

			    	break;
			    	
			    	case 8:   ParkingRateUtility.ParkingRatetMenu();
			    	
			    	break;

			    	case 9 :  PaymentUtility.PaymentMenu();

			    	break;

			    	

			    	default : System.out.println("Invalid choice. Please try again."); 

			    	break; 

			    		

		    	 }

		    	 System.out.println("Do you want to continue the update");	

		         scanner.nextLine();

		         option = scanner.nextLine().charAt(0);

		       } while (option == 'y'|| option == 'Y');				

		}


	



	}


