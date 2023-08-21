package com.canddella.utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Payment;
import com.canddella.entity.Reservation;
import com.canddella.service.PaymentServiceImpl;
import com.canddella.service.ReservationServiceImpl;

public class PaymentUtility {

	public static void main(String[] args) {
		PaymentMenu();

	}

	public static void PaymentMenu() {
		char choice;
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.InsertPayment\n 2.view Payment \n 3.delete payment\n 4.view all payment\n ");
		System.out.println("Enter your choice\n");
		int ch=scanner.nextInt();
		if(ch==1)
		{
			insertPayment();
		
		}
		else if(ch==2)
		{
			viewPayment();
		}
		else if(ch==3)
		{
			deletePayment();
		}
		else if(ch==4)
		{
			listAllPayment();
		}
		System.out.println("do yo want to continue");
		scanner.nextLine();
		choice=scanner.next().charAt(0);
	}   while ((choice=='y')||(choice=='Y'));
	}

	



	private static void insertPayment() {
		 Scanner scanner=new Scanner(System.in);
			
		    Payment payment=null;
			
			System.out.println("enter the paymentid");
			String paymentId=scanner.nextLine();
			//scanner.nextInt();
			CustomerUtility.listAllCustomer();
			System.out.println("enter the customerid");
		    //scanner.nextLine();
			int customerId=scanner.nextInt();
			scanner.nextLine();
			ReservationUtility.listAllReservation();
			System.out.println("enter the reservationid ");
			String reservation_id =scanner.nextLine();
			
			
			System.out.print("Enter the payamentTime (HH:mm): ");
	        String timeInput = scanner.nextLine();
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	        LocalTime paymentTime = LocalTime.parse(timeInput, timeFormatter);
	        
	        System.out.println("enter the payment date\n");
			String paymentDate=scanner.nextLine();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate paymentdate=LocalDate.parse(paymentDate, formatter);
	        
	       
	        System.out.println("enter the amount ");
			double amount=scanner.nextDouble();
	        
	        
			
			
			
			Customer customer=new Customer();
			customer.setCustomerId(customerId);
			Reservation reservation=new Reservation();
			reservation.setReservationId(reservation_id);
			
			payment= new Payment(paymentId,customer,reservation,paymentTime,paymentdate,amount );
			
			PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
			paymentServiceImpl.savePayment(payment);
		
	}
	private static void viewPayment() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the payment Id");
		String paymentId=scanner.nextLine();
		PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		paymentServiceImpl.viewPayment( paymentId);
		
	}

	private static void deletePayment() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the payment Id");
		String paymentId=scanner.nextLine();
		PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		paymentServiceImpl.deletePayment(paymentId);
	}

	private static void listAllPayment() {
		PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		List<Payment>paymentList=null;
		paymentList=paymentServiceImpl.listAllPayment();
		System.out.println("+-----------------+-------------------+------------------+----------------+--------------+--------------+");

        System.out.printf("| %-14s | %-13s | %-16s | %-14s | %-12s | %-12s |\n",

                "payment_id", "Customer_id", "reservation_id", "payment_time", "payment_date",

                "amount");

        System.out.println("+---------------+-------------------+------------------+----------------+--------------+--------------+");
		 for (Payment payment : paymentList) { 
			 if (payment!=null)
			 {
				 System.out.printf("| %-14s | %-13s | %-16s | %-14s | %-12s | %-12s |\n",
						payment.getPaymentId(),payment.getCustomer().getCustomerId(),
						payment.getReservation().getReservationId(),payment.getPaymentTime(),
						payment.getPaymentDate(),payment.getAmount());
						 
						 
						 
				 System.out.println("+-----------------+-------------------+------------------+----------------+--------------+--------------+");
			

		    	

		    }
		 }
		
	}

	}
	


