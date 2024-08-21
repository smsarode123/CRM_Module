package com.insurance.registrationservice.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.repository.CustomerRepository;
import com.insurance.registrationservice.service.CustomerServiceI;
@Service
public class CustomerServiceImpl implements CustomerServiceI{
	
	private CustomerRepository repository;

	@Override
	public Customer saveCustomers(Customer customer) {
		
		return repository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return repository.findAll();
	}


}
