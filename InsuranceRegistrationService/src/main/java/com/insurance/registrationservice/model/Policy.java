package com.insurance.registrationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PolicyId;
	private String policyType;
	private float policyCoverage;
	private float Limit;
	private String policyPreviosExpireDate;
	private String policyCurrentExpireDate;
	private String policyStartDate;
	private String policyClaimDate;
	private String policyCoverageOption;
	private float policyPremium;
	

}
