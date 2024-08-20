package com.insurance.registrationservice.model;

import java.util.List;

import org.hibernate.engine.internal.Cascade;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CustomerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerAddress;
	private Long customerContact;
	private Long customerAdharId;
	private String customerEmail;
	private String customerPanId;
	private String customerUsername;
	private String customerPassword;
	private String customerDOB;
	private String customerGender;
	@OneToOne(cascade = CascadeType.DETACH.MERGE.PERSIST.REFRESH.REMOVE)
	private Policy policyname;
	@OneToMany(cascade = CascadeType.DETACH.MERGE.PERSIST.REFRESH.REMOVE)
	private List<Vehicle>vehiclename;

}
