package com.insurance.registrationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.registrationservice.model.Vehicle;
import com.insurance.registrationservice.service.CustomerServiceI;

@RestController
public class VehicleHomeController {
	
	@Autowired private CustomerServiceI custumerservice;
	
	
	@PostMapping("/AddVehicle")
	private ResponseEntity <Vehicle> Adddatatovehicle(@RequestBody Vehicle vehicle)
	{
		
		Vehicle vehicledata=custumerservice.insertdataofcustomer(vehicle);
		
		return new ResponseEntity <Vehicle>(vehicledata, HttpStatus.CREATED);
	}

}
