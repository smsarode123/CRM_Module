package com.insurance.registrationservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
