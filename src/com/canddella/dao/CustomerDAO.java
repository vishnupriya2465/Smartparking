package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Customer;
import com.canddella.entity.FloorDetails;


public interface CustomerDAO {
	public void saveCustomer(Customer customer);
	public Customer viewCustomer(int customerId);
	public Customer deleteCustomer(int customerId);
	public List<Customer>listAllCustomer();
	
}
