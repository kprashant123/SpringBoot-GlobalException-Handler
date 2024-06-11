package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.customer.exception.CustomerAlreadyExistsException;
import com.customer.exception.ErrorResponse;
import com.customer.model.Customer;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("getCustomer/{id}")
	public Customer getCustomer(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@PutMapping("updateCustomer")
	public String updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	// Exception Handler method added in CustomerController to handle CustomerAlreadyExistsException
	@ExceptionHandler(value = CustomerAlreadyExistsException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ErrorResponse handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
	
	
	
}
