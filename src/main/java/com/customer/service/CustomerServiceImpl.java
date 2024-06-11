package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.exception.CustomerAlreadyExistsException;
import com.customer.exception.NoSuchCustomerExistsException;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	// method to get customer by id
	// NoSuchElementException for invalid id
	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new NoSuchCustomerExistsException("For the given id no customer exist : " + id));
	}

	// Method to add new customer details to database.Throws
	// CustomerAlreadyExistsException when customer detail
	// already exist
	@Override
	public String addCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
		if (existingCustomer == null) {
			customerRepository.save(customer);
			return "Customer Added Successfully.";
		} else
			throw new CustomerAlreadyExistsException("Customer Already Exist");
	}

	 // Method to update customer details to database.Throws
    // NoSuchCustomerExistsException when customer doesn't
    // already exist in database
	@Override
	public String updateCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
		
		if(existingCustomer == null) {
			throw new NoSuchCustomerExistsException("No Such Customer Exists");
		}
		else {
			existingCustomer.setName(customer.getName());
			existingCustomer.setAddress(customer.getAddress());
			customerRepository.save(existingCustomer);
			return "Record Updated Successfully";
		}
	}

}
