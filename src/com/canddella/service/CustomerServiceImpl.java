package com.canddella.service;

import java.util.List;

import com.canddella.dao.CustomerDAOImpl;
import com.canddella.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAOImpl customerdaoimpl = new CustomerDAOImpl();


	@Override
	public void saveCustomer(Customer customer) {
		customerdaoimpl.saveCustomer(customer);
		
		
	}

	@Override
	public Customer viewCustomer(int customerId) {
		return customerdaoimpl.viewCustomer(customerId);
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		return customerdaoimpl.deleteCustomer(customerId);
	}

	@Override
	public List<Customer> listAllCustomer() {
	return customerdaoimpl.listAllCustomer();
	}

	

	
	}

	
	
	


