package com.insurance.registrationservice.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.model.Policy;
import com.insurance.registrationservice.repository.CustomerRepository;
import com.insurance.registrationservice.repository.PolicyRepository;
import com.insurance.registrationservice.service.CustomerServiceI;
@Service
public class CustomerServiceImpl implements CustomerServiceI{
	
	private CustomerRepository repository;
	private PolicyRepository policyrepository;

	@Override
	public Customer saveCustomers(Customer customer) {
		
		return repository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return repository.findAll();
	}

	@Override
	public Policy savePolicy(Policy policy) {
		
		return policyrepository.save(policy);
	}

	@Override
	public List<Policy> getAllPolicy() {
		
		return policyrepository.findAll();
	}

	@Override
	public Policy getSinglePolicy(int policyId) {
		
		return policyrepository.findById(policyId).get();
	}

	@Override
	public Policy updatePolicyById(Policy policy) {
		
		return policyrepository.save(policy);
	}

	@Override
	public void deletePolicyByPolicyId(int policyId) {
		
		policyrepository.deleteById(policyId);
	}

	


}
