package com.canddella.entity;

public class Customer {
	private int customerId;
	private String customerFirstname;
	private String customerLastname;
	private String customerPhoneNumber;
	private String customerAddress;
	public Customer(int customerId, String customerFirstname, String customerLastname, String customerPhoneNumber,
			String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerFirstname = customerFirstname;
		this.customerLastname = customerLastname;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerAddress = customerAddress;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerFirstname() {
		return customerFirstname;
	}
	public void setCustomerFirstname(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}
	public String getCustomerLastname() {
		return customerLastname;
	}
	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	
	
	
	

}
