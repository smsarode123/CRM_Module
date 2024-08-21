package com.insurance.registrationservice.service;

import java.util.List;

import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.model.Policy;

public interface CustomerServiceI {

	Customer saveCustomers(Customer customer);

	List<Customer> getAllCustomer();

	Policy savePolicy(Policy policy);

	List<Policy> getAllPolicy();

	Policy getSinglePolicy(int policyId);

	

	Policy updatePolicyById(Policy policy);

	void deletePolicyByPolicyId(int policyId);

}
