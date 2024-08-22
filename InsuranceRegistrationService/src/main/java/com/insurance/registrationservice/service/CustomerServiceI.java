package com.insurance.registrationservice.service;

import java.util.List;

import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.model.Vehicle;

public interface CustomerServiceI {

	Customer saveCustomers(Customer customer);

	List<Customer> getAllCustomer();

	Vehicle insertdataofcustomer(Vehicle vehicle);

	Iterable<Vehicle> SelectAllVehicle();

	void RemoveVehicleById(int vehicleid);

	Vehicle UpdateVehicleData(Vehicle vehicle, int vehicleid);

	Customer getSingleCustomerById(int customerId);

	Customer updateCustomer(Customer customer, int customerId);

	void deleteCustomer(int customerId);

}
