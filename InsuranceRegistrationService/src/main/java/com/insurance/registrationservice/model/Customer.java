package com.insurance.registrationservice.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerAddress;
	private long customerContactNumber;
	private long customerAdharNumber;
	private String customerEmailId;
	private String customerPancardNumber;
	private Date customerDateOfBirth;
	private String customerGender;
	private String customerUsername;
	private String customerPassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Policy policy;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Vehicle> vehicle;

}

