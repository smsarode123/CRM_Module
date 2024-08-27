package com.insurance.registrationservice.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.insurance.registrationservice.exception.InvalidCustomerIdException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.registrationservice.exceptions.DocumentsNotFoundByIdException;
import com.insurance.registrationservice.exceptions.DocumentsNotUploadException;
import com.insurance.registrationservice.exceptions.DocumentsNotUploadedYetException;

import com.insurance.registrationservice.model.Customer;

import com.insurance.registrationservice.model.Vehicle;
import com.insurance.registrationservice.model.Policy;

import com.insurance.registrationservice.model.Document;

import com.insurance.registrationservice.repository.CustomerRepository;

import com.insurance.registrationservice.repository.VehicleRepository;
import com.insurance.registrationservice.repository.PolicyRepository;

import com.insurance.registrationservice.repository.DocumentRepository;

import com.insurance.registrationservice.service.CustomerServiceI;

@Service

public class CustomerServiceImpl implements CustomerServiceI{
	
	@Autowired private CustomerRepository repository;

	@Autowired private DocumentRepository documentRepository;
	
	


	private VehicleRepository vehiclerepository;

	private PolicyRepository policyrepository;

	@Override

	public Vehicle insertdataofcustomer(Vehicle vehicle) {

		Vehicle vehicledata = vehiclerepository.save(vehicle);

		return vehicledata;
	}

	@Override
	public Iterable<Vehicle> SelectAllVehicle() {

		Iterable<Vehicle> vehicledata = vehiclerepository.findAll();

		return vehicledata;
	}

	@Override
	public void RemoveVehicleById(int vehicleid) {

		vehiclerepository.deleteById(vehicleid);

	}

	@Override
	public Vehicle UpdateVehicleData(Vehicle vehicle, int vehicleid) {

		vehiclerepository.findById(vehicleid);

		Vehicle vehicledata = vehiclerepository.save(vehicle);

		return vehicledata;
	}
	
	public Document uploadDocuments(String documentJson, MultipartFile pancard, MultipartFile adharcard, MultipartFile profile,
			MultipartFile vehicleRc, MultipartFile vehicle) {
		
		ObjectMapper mapper=new ObjectMapper();
		try {
			Document document=mapper.readValue(documentJson, Document.class);
				document.setPancardImage(pancard.getBytes());
				document.setAdharcardImgae(adharcard.getBytes());
				document.setProfileImage(profile.getBytes());
				document.setVehicleRcImage(vehicleRc.getBytes());
				document.setVehicleImage(vehicle.getBytes());
				Document docRef=documentRepository.save(document);
				
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Customer> getAllCustomer() {

		List<Customer> list = repository.findAll();

		return list;
	}
	
	public List<Document> getAllDocumentsDetails() {
		List<Document> docList=documentRepository.findAll();
		if(!docList.isEmpty())
		{
			return docList;
		} else {
			throw new DocumentsNotUploadedYetException("Documents Not Uploaded");
		}

	}

	@Override
	public Customer saveCustomers(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer getSingleCustomerById(int customerId) {

		Optional<Customer> customer = repository.findById(customerId);

		if (customer.isPresent()) {

			return customer.get();
		} else {
			throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer, int customerId) {
		Optional<Customer> customerRef = repository.findById(customerId);

		if (customerRef.isPresent()) {
			return repository.save(customer);
		}

		else {
			throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");
		}

	}

	@Override
	public void deleteCustomer(int customerId) {

		Optional<Customer> customerRef = repository.findById(customerId);

		if (customerRef.isPresent()) {
			repository.deleteById(customerId);
		} else {
			throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");

		}
	}

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

	public Document getSingleDocumentDetails(int documentId) {
		Optional<Document> option=documentRepository.findById(documentId);
		if(option.isPresent())
		{
			Document docRef=option.get();
			return docRef;
		} else {
			throw new DocumentsNotFoundByIdException("Documents Not Found on Id-"+documentId);
		}
	}

	@Override
	public void deleteDocumentById(int documentId) {
		
		documentRepository.deleteById(documentId);
	}

	@Override
	public Document updateDocumentDetails(String documentJson, MultipartFile pancard, MultipartFile adharcard,
			MultipartFile profile, MultipartFile vehicleRc, MultipartFile vehicle) {
		ObjectMapper mapper=new ObjectMapper();
		try {
			Document document=mapper.readValue(documentJson, Document.class);
			document.setPancardImage(pancard.getBytes());
			document.setAdharcardImgae(adharcard.getBytes());
			document.setProfileImage(profile.getBytes());
			document.setVehicleRcImage(vehicleRc.getBytes());
     		document.setVehicleImage(vehicle.getBytes());
			Document docRef=documentRepository.save(document);
			return docRef;
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	


}
