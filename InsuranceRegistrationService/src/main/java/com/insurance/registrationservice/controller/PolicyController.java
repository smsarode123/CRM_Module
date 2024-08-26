package com.insurance.registrationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.insurance.registrationservice.model.Policy;
import com.insurance.registrationservice.service.CustomerServiceI;

public class PolicyController {

	@Autowired
	CustomerServiceI csi;

	@PostMapping("/savepolicy")
	public ResponseEntity<Policy> savePolicy(@RequestBody Policy policy) {
		Policy policyRef = csi.savePolicy(policy);
		return new ResponseEntity<Policy>(policyRef, HttpStatus.CREATED);
	}

	@GetMapping("/getAllPolicy")
	public ResponseEntity<List<Policy>> getAllPolicy() {
		List<Policy> policies = csi.getAllPolicy();

		return new ResponseEntity<List<Policy>>(policies, HttpStatus.OK);
	}

	@GetMapping("/getSinglepolicy/{policyId}")
	public ResponseEntity<Policy> getSinglePolicy(@PathVariable int policyId) {
		Policy policy = csi.getSinglePolicy(policyId);

		return new ResponseEntity<Policy>(policy, HttpStatus.OK);

	}

	@PutMapping("updatepolicyById/{policyId}")
	public ResponseEntity<Policy> updatePolicyById(@RequestBody Policy policy, @PathVariable int policyId) {
		Policy policy1 = csi.updatePolicyById(policy);

		return new ResponseEntity<Policy>(policy1, HttpStatus.OK);

	}

	@DeleteMapping("dalatepolicyById/{policyId}")
	public ResponseEntity<String> deletePolicyByPolicyId(@PathVariable int policyId) {
		csi.deletePolicyByPolicyId(policyId);

		return new ResponseEntity<String>(HttpStatus.OK);

	}

}
