package com.insurance.registrationservice.serviceimpl;

import org.springframework.stereotype.Service;

import com.insurance.registrationservice.repository.CustomerRepository;
import com.insurance.registrationservice.service.CustomerServiceI;
@Service
public class CustomerServiceImpl implements CustomerServiceI{
	
	private CustomerRepository repository;


}
