package com.insurance.registrationservice.service;



import java.util.List;


import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.model.Vehicle;
import com.insurance.registrationservice.model.Policy;

import org.springframework.web.multipart.MultipartFile;

import com.insurance.registrationservice.model.Document;


public interface CustomerServiceI {

	public Document uploadDocuments(String documentJson, MultipartFile pancard, MultipartFile adharcard, MultipartFile profile,
			MultipartFile vehicleRc, MultipartFile vehicle);

	public List<Document> getAllDocumentsDetails();

	public Document getSingleDocumentDetails(int documentId);

	public void deleteDocumentById(int documentId);

	public Document updateDocumentDetails(String documentJson, MultipartFile pancard, MultipartFile adharcard,
			MultipartFile profile, MultipartFile vehicleRc, MultipartFile vehicle);


	Iterable<Vehicle> SelectAllVehicle();

	void RemoveVehicleById(int vehicleid);

	Vehicle UpdateVehicleData(Vehicle vehicle, int vehicleid);

	Customer getSingleCustomerById(int customerId);

	Customer updateCustomer(Customer customer, int customerId);

	void deleteCustomer(int customerId);

	Policy savePolicy(Policy policy);

	List<Policy> getAllPolicy();

	Policy getSinglePolicy(int policyId);

	Policy updatePolicyById(Policy policy);

	void deletePolicyByPolicyId(int policyId);

	Vehicle insertdataofcustomer(Vehicle vehicle);

	public Customer saveCustomers(Customer customer);

	public List<Customer> getAllCustomer();

}
