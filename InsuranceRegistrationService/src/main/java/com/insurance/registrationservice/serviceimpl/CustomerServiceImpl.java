package com.insurance.registrationservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.insurance.registrationservice.exception.InvalidCustomerIdException;
import com.insurance.registrationservice.exception.InvalidPolicyIdException;
import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.model.Vehicle;
import com.insurance.registrationservice.model.Policy;
import com.insurance.registrationservice.repository.CustomerRepository;
import com.insurance.registrationservice.repository.VehicleRepository;
import com.insurance.registrationservice.repository.PolicyRepository;
import com.insurance.registrationservice.service.CustomerServiceI;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

	private CustomerRepository repository;

	private VehicleRepository vehiclerepository;

	private PolicyRepository policyrepository;

	@Override
	public Vehicle insertdataofcustomer(Vehicle vehicle) {

		Vehicle vehicledata = vehiclerepository.save(vehicle);

		return vehicledata;
	}

	@Override
	public Iterable<Vehicle> SelectAllVehicle() {

		Iterable<Vehicle> vehicledata = vehiclerepository.findAll();

		return vehicledata;
	}

	@Override
	public void RemoveVehicleById(int vehicleid) {

		vehiclerepository.deleteById(vehicleid);

	}

	@Override
	public Vehicle UpdateVehicleData(Vehicle vehicle, int vehicleid) {

		vehiclerepository.findById(vehicleid);

		Vehicle vehicledata = vehiclerepository.save(vehicle);

		return vehicledata;

	}

	@Override
	public List<Customer> getAllCustomer() {

		List<Customer> list = repository.findAll();

		return list;
	}

	@Override
	public Customer saveCustomers(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer getSingleCustomerById(int customerId) {

		Optional<Customer> customer = repository.findById(customerId);

		if (customer.isPresent()) {

			return customer.get();
		} else {
			throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer, int customerId) {
		Optional<Customer> customerRef = repository.findById(customerId);

		if (customerRef.isPresent()) {
			return repository.save(customer);
		}

		else {
			throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");
		}

	}

	@Override
	public void deleteCustomer(int customerId) {

		Optional<Customer> customerRef = repository.findById(customerId);

		if (customerRef.isPresent()) {
			repository.deleteById(customerId);
		} else {
			throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");

		}
	}

	
	
	public Policy savePolicy(Policy policy) {

		return policyrepository.save(policy);
	}

	@Override
	public List<Policy> getAllPolicy() {

		return policyrepository.findAll();
	}

	@Override
	public Policy getSinglePolicy(int policyId) {

		Optional<Policy> policy= policyrepository.findById(policyId);

		if (policy.isPresent()) {

			return policy.get();
		} else {
			throw new InvalidPolicyIdException("Policy id " + policyId + " is not valid");
		}
	}

	
	@Override
	public Policy updatePolicyById(Policy policy, int policyId) {
		
		Optional<Policy> policyRef = policyrepository.findById(policyId);

		if (policyRef.isPresent()) {
			return policyrepository.save(policy);
		}

		else {
			throw new InvalidPolicyIdException("policy id " +  policyId + " is not valid");
		}
	}
   
	
	@Override
	public void deletePolicyByPolicyId(int policyId) {


		Optional<Policy> policyRef = policyrepository.findById(policyId);

		if (policyRef.isPresent()) {
			policyrepository.deleteById(policyId);
		} else {
			throw new InvalidPolicyIdException("Policy id " + policyId + " is not valid");

		}

	}

}
