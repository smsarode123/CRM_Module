package com.insurance.registrationservice.model;

import java.util.Date;

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
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyId;
	private String policyName;
	private String policyCoverageExpiryLimit;
	private Date policyStartDate;
    private Date policyExpiryDate;
    private Date policyClaimDate;
    private String policyCoverageOptions;
    private String policyPremium;
    
    
}
