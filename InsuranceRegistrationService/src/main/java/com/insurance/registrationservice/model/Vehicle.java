package com.insurance.registrationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleid;
	private int vehiclercnumber;
	private String vehicleownername;
	private String vehicletype;
	private String vehiclemanufacturename;
	private String vehiclemodel;
	private String vehicleRegistrationDate;
	private String vehicleRegistrationUpto;

}
