package com.customer.service;

import org.springframework.stereotype.Component;

import com.customer.model.Customer;

@Component
public interface CustomerService {
	//method to get customer by id
	Customer getCustomer(Long id);
	//method to add a new customer
	//into the database
	String addCustomer(Customer customer);
	//method to update customer details
	String updateCustomer(Customer customer);
}
