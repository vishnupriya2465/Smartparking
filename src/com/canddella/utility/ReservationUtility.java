package com.canddella.utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Floor_Slot;
import com.canddella.entity.Floorslot_Availability;
import com.canddella.entity.Reservation;
import com.canddella.service.ReservationServiceImpl;


public class ReservationUtility {

	private static final Object AVAILABILITY = null;
	private static final Object AVAILABLE = null;

	public static void main(String[] args) {
		ReservationMenu();

	}

	public static void ReservationMenu() {
		char choice;
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.InsertReservation\n 2.view Reservation \n 3.delete Reservation\n 4.view all Reservation\n ");
		System.out.println("Enter your choice\n");
		int ch=scanner.nextInt();
		if(ch==1)
		{
			insertReservation();
		
		}
		else if(ch==2)
		{
			viewReservation();
		}
		else if(ch==3)
		{
			deleteReservation();
		}
		else if (ch==4)
		{
			listAllReservation();
		}
		System.out.println("do yo want to continue");
		scanner.nextLine();
		choice=scanner.next().charAt(0);
	}   while ((choice=='y')||(choice=='Y'));
	}



		private static void insertReservation() {
	    Scanner scanner=new Scanner(System.in);
		
      Reservation reservation=null;
		
		System.out.println("enter the reservationid");
		String reservationId=scanner.nextLine();
		//scanner.nextInt();
		CustomerUtility.listAllCustomer();
		System.out.println("enter the customerid");
	    //scanner.nextLine();
		int customerId=scanner.nextInt();
		
		Floor_SlotUtility.listallfloor_slot();
		System.out.println("enter the floor_slot id ");
		int floor_slot_id =scanner.nextInt();
		
		scanner.nextLine();
		System.out.println("enter the reservation date\n");
		String reservationDate=scanner.nextLine();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate reservationdate=LocalDate.parse(reservationDate, formatter);
		
		System.out.print("Enter the reservation Time (HH:mm): ");
        String timeInput = scanner.nextLine();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime reservationTime = LocalTime.parse(timeInput, timeFormatter);
        
        System.out.print("Enter the start Time (HH:mm): ");
        String timeInput1 = scanner.nextLine();
        DateTimeFormatter timeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime startTime = LocalTime.parse(timeInput1, timeFormatter);
        
        System.out.print("Enter the end Time (HH:mm): ");
        String timeInput2 = scanner.nextLine();
        DateTimeFormatter timeFormatter2 = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime endTime = LocalTime.parse(timeInput, timeFormatter);
        
        System.out.println("enter the status ");
		String status=scanner.nextLine();
        
        
		
		
		
		Customer customer=new Customer();
		customer.setCustomerId(customerId);
		Floor_Slot floor_slot=new Floor_Slot();
		floor_slot.setFloor_SlotId(floor_slot_id);
		ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
		//String availability = reservationServiceImpl.Totalavailability(floor_slot_id);
		
		Floorslot_Availability floorslot_Availability = reservationServiceImpl.Totalavailability(floor_slot);

	//	System.out.println("Availability: " + availability);
		System.out.println("Id: " +floorslot_Availability.getFloorslot_AvailabilityId());
		System.out.println("status: "+floorslot_Availability.getStatus());

	//List<Floorslot_Availability>slotList=new ArrayList<>();
//	if (floorslot_Availability.getStatus() != null && floorslot_Availability.getStatus().equals(AVAILABLE)) {
		String status1="AVAILABLE";
				
				
		if ( floorslot_Availability.getStatus().equalsIgnoreCase(status1)) {
	//	for (Floorslot_Availability slots:slotList)
		//{
			//System.out.println(slots.getFloorslot_AvailabilityId());
			
			
		
		 reservation = new Reservation(reservationId, customer, floor_slot, reservationdate, reservationTime, startTime, endTime, status);
	    reservationServiceImpl.saveReservation(reservation);
		//}
	} 
	else {
		    System.out.println("No available space");
		}


	}
		
		private static void viewReservation() {
			Scanner scanner=new Scanner(System.in);
			System.out.println("enter the reservation Id");
			String reservationId=scanner.nextLine();
			ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
			reservationServiceImpl.viewReservation( reservationId);
			
		}


		private static void deleteReservation() {
			Scanner scanner=new Scanner(System.in);
			System.out.println("enter the Reservation Id");
			String reservationId=scanner.nextLine();
			ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
			reservationServiceImpl.deleteReservation(reservationId);
		
		
	}

		public static void listAllReservation() {
			ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
			List<Reservation>reservationList=null;
			reservationList=reservationServiceImpl.listAllReservation();
			System.out.println("+-----------------+-------------------+------------------+----------------+--------------+--------------+----------------+-----------------+");

	        System.out.printf("| %-14s | %-13s | %-16s | %-14s | %-12s | %-12s | %-14s | %-15s |\n",

	                "Reservation_id", "Customer_id", "Floor_Slot_id", "Reservation_Date", "Reservation_Time",

	                "Start_Time", "End_time", "Status");

	        System.out.println("+---------------+-------------------+------------------+----------------+--------------+--------------+----------------+-----------------+");
			 for (Reservation reservation : reservationList) { 
				 if (reservation!=null)
				 {
					 System.out.printf("| %-14s | %-13s | %-16s | %-14s | %-12s | %-12s | %-14s | %-15s |\n",
							 reservation.getReservationId(),reservation.getCustomer().getCustomerId(),
							 reservation.getFloor_slot().getFloor_SlotId(),reservation.getReservationDate(),
							 reservation.getReservationTime(),reservation.getStartTime(),reservation.getEndTime(),
							 reservation.getStatus());
							 
							 
							 
					 System.out.println("+-----------------+-------------------+------------------+----------------+--------------+--------------+----------------+-----------------+");
				

			    	

			    }
			 }
			
		}

		
			
		}
			
	
	
