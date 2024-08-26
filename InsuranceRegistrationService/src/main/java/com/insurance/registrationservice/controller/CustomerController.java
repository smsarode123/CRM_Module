package com.insurance.registrationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.model.Policy;
import com.insurance.registrationservice.service.CustomerServiceI;

@RestController
public class CustomerController {

	@Autowired CustomerServiceI csi;
	
	
	@PostMapping("/savecustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
	{
		Customer customerRef = csi.saveCustomers(customer);
		
		return new ResponseEntity<Customer>(customerRef, HttpStatus.CREATED);
		
	}

	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		List<Customer> customers =csi.getAllCustomer();
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
}
