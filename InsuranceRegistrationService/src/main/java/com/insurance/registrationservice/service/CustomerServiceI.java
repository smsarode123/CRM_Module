package com.insurance.registrationservice.service;

import java.util.List;

import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.model.Vehicle;
import com.insurance.registrationservice.model.Policy;

public interface CustomerServiceI {

	Customer saveCustomers(Customer customer);

	List<Customer> getAllCustomer();


	Iterable<Vehicle> SelectAllVehicle();

	void RemoveVehicleById(int vehicleid);

	Vehicle UpdateVehicleData(Vehicle vehicle, int vehicleid);

	Customer getSingleCustomerById(int customerId);

	Customer updateCustomer(Customer customer, int customerId);

	void deleteCustomer(int customerId);

	Policy savePolicy(Policy policy);

	List<Policy> getAllPolicy();

	Policy getSinglePolicy(int policyId);

	Policy updatePolicyById(Policy policy);

	void deletePolicyByPolicyId(int policyId);

	Vehicle insertdataofcustomer(Vehicle vehicle);

}
