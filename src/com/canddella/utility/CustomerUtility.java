package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Floorslot_Availability;
import com.canddella.service.CustomerServiceImpl;



public class CustomerUtility {

	public static void main(String[] args) {
		CustomerMenu();
	}

	public static void CustomerMenu() {
		char choice;
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.InsertCustomer\n 2.view Customer \n 3.delete Customer\n 4.view all Customer\n 5.updateCustomer");
		System.out.println("Enter your choice\n");
		int ch=scanner.nextInt();
		if(ch==1)
		{
			insertCustomer();
		
		}
		else if(ch==2)
		{
			viewCustomer();
		}
		else if(ch==3)
		{
			deleteCustomer();
		}
		else if(ch==4)
		{
			listAllCustomer();
		}
		System.out.println("do yo want to continue");
		choice=scanner.next().charAt(0);
	}while ((choice=='y')||(choice=='Y'));

}

	

	
     private static void insertCustomer() {
     Scanner scanner=new Scanner(System.in);
		
        Customer customer=null;
		
		System.out.println("enter the Customerid");
		int customerId=scanner.nextInt();
		//scanner.nextInt();
		System.out.println("enter the customerFirstname");
		scanner.nextLine();
		String customerFirstname=scanner.nextLine();
		
		System.out.println("enter the customerLastname ");
		String customerLastname =scanner.nextLine();
		System.out.println("enter the customerPhoneNumber ");
		String customerPhoneNumber =scanner.nextLine();
		System.out.println("enter the customerAddress ");
		String customerAddress =scanner.nextLine();
		
		
//		Floorslot_Availability floorslot_availability = new Floorslot_Availability();
//		floorslot_availability.setFloorslot_AvailabilityId(floorslot_availabilityId);
//		Customer customer = new Customer();
//		customer.setCustomerId(customerId);
		
		
		
	
		 
	
			customer= new Customer(customerId,customerFirstname,customerLastname,customerPhoneNumber,customerAddress );
			CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
			customerServiceImpl.saveCustomer(customer);
		
		
		
		
		//customer= new Customer(customerId,customerFirstname,customerLastname,customerPhoneNumber,customerAddress );
		
		//CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		//customerServiceImpl.saveCustomer(customer);
		
		
	}
	    private static void viewCustomer() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the CustomerId");
		int customerId=scanner.nextInt();
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.viewCustomer(customerId);
		
	}
	    private static void deleteCustomer() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the CustomerId");
		int customerId=scanner.nextInt();
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.deleteCustomer(customerId);
	}
	    public static void listAllCustomer() {
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		List<Customer>customerList=null;
		customerList=customerServiceImpl.listAllCustomer();
		
		System.out.println("+-----------------+---------------------+---------------------+----------------------------+--------------------+");

        System.out.printf("| %-14s | %-20s | %-20s | %-26s | %-16s |\n",

                "Customer id", "CustomerFirstname", "CustomerLastname", "customerPhoneNumber", "customerAddress");

                

        System.out.println("+---------------+------------------------+---------------------+---------------------------+--------------------+");
		
	  for (Customer customer : customerList) { 
			 if (customer!=null)
			 {
			 System.out.printf("| %-14s | %-20s | %-20s | %-26s | %-16s |\n",
					 customer.getCustomerId(),
					 customer.getCustomerFirstname(),
					 customer.getCustomerLastname(),
					 customer.getCustomerPhoneNumber(),
					 customer.getCustomerAddress());
						 
						 
			System.out.println("+-----------------+---------------------+---------------------+-----------------------------+--------------------+");
					
		    	
		    }
		 }
	}
}