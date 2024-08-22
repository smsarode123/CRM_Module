package com.insurance.registrationservice.model;


import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	private int vehicleId;
	private String vehicleOwnerName;
	private String vehicleType;
	private String vehicleRcNumber;
	private String vehicleManufacturer;
	private String vehicleModelName;
	private Date vehicleRegistrationDate;
	private Date vehicleRegistrationUpto;
	@OneToOne(cascade = CascadeType.ALL)
	private Policy policy;

	
}
