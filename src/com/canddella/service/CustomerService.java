package com.canddella.service;

import java.util.List;

import com.canddella.entity.Customer;
import com.canddella.entity.FloorDetails;


public interface CustomerService {
	public void saveCustomer(Customer customer);
	public Customer viewCustomer(int customerId);
	public Customer deleteCustomer(int customerId);
	public List<Customer>listAllCustomer();
	
	
	
}
