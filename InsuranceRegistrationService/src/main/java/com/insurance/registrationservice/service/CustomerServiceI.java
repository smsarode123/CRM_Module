package com.insurance.registrationservice.service;

import java.util.List;

import com.insurance.registrationservice.model.Vehicle;

public interface CustomerServiceI {

	Vehicle insertdataofcustomer(Vehicle vehicle);

	Iterable<Vehicle> SelectAllVehicle();

	void RemoveVehicleById(int vehicleid);

	Vehicle UpdateVehicleData(Vehicle vehicle, int vehicleid);

}
