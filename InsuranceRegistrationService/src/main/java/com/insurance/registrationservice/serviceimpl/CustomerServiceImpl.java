package com.insurance.registrationservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.insurance.registrationservice.exception.InvalidCustomerIdException;
import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.model.Vehicle;
import com.insurance.registrationservice.repository.CustomerRepository;
import com.insurance.registrationservice.repository.VehicleRepository;
import com.insurance.registrationservice.service.CustomerServiceI;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

	private CustomerRepository repository;
	private VehicleRepository vehiclerepository;

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
		Optional<Customer> customerRef =repository.findById(customerId);
		
		if(customerRef.isPresent()) {
			return repository.save(customer);
		}
		
		else {
			throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");
		}
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		Optional<Customer> customerRef=repository.findById(customerId);
		
		if(customerRef.isPresent()) 
		{
			repository.deleteById(customerId);
		}
		else {
			throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");
 
		}
	}
	
}
