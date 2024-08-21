package com.insurance.registrationservice.service;

import java.util.List;

import com.insurance.registrationservice.model.Customer;

public interface CustomerServiceI {

	Customer saveCustomers(Customer customer);

	List<Customer> getAllCustomer();

	Customer getSingleVehicleById(int customerId);

}
