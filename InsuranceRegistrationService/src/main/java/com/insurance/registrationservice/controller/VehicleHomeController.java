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

import com.insurance.registrationservice.model.Vehicle;
import com.insurance.registrationservice.service.CustomerServiceI;

@RestController
public class VehicleHomeController {
	
	@Autowired private CustomerServiceI custumerservice;
	
	
	@PostMapping("/AddVehicle")
	public ResponseEntity <Vehicle> Adddatatovehicle(@RequestBody Vehicle vehicle)
	{
		
		Vehicle vehicledata=custumerservice.insertdataofcustomer(vehicle);
		
		return new ResponseEntity <Vehicle>(vehicledata, HttpStatus.CREATED);
	}
	
	@GetMapping("/GetVehicle")
	public ResponseEntity<Iterable<Vehicle>>GetAllVehicle()
	{
		
		Iterable<Vehicle>vehicledata=custumerservice.SelectAllVehicle();
		
		return new ResponseEntity<Iterable<Vehicle>>(vehicledata, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/DeleteVehicle")
	public ResponseEntity<String>RemoveVehicleData(@PathVariable ("vehicleid") int vehicleid)
	{
	     custumerservice.RemoveVehicleById(vehicleid);
		
		return new ResponseEntity<String>("Vehicle Data Deleted Successfully", HttpStatus.GONE);
	}
	
	@PutMapping("/PutVehicle")
	public ResponseEntity<Vehicle>PutDataOfVehicle(@RequestBody Vehicle vehicle,@PathVariable ("vehicleid") int vehicleid)
	{
		
		Vehicle vehicledata=custumerservice.UpdateVehicleData(vehicle,vehicleid);
		
		return new ResponseEntity<Vehicle>(vehicledata, HttpStatus.OK);
		
	}
}
