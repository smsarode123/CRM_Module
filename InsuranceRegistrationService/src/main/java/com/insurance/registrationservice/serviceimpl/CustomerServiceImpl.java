package com.insurance.registrationservice.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.registrationservice.model.Vehicle;
import com.insurance.registrationservice.repository.CustomerRepository;
import com.insurance.registrationservice.repository.VehicleRepository;
import com.insurance.registrationservice.service.CustomerServiceI;
@Service
public class CustomerServiceImpl implements CustomerServiceI{
	
	private CustomerRepository repository;
	private VehicleRepository vehiclerepository;

	@Override
	public Vehicle insertdataofcustomer(Vehicle vehicle) {
		
	     Vehicle vehicledata=vehiclerepository.save(vehicle);
		
		return vehicledata;
	}

	


}
