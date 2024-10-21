package com.insurance.registrationservice.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.registrationservice.exception.InvalidCustomerIdException;
import com.insurance.registrationservice.exceptions.DocumentsNotFoundByIdException;
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
import com.insurence.registrationservice.utility.Utility;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Autowired private CustomerRepository repository;
    @Autowired private DocumentRepository documentRepository;
    @Autowired JavaMailSender mailsender;

    // Remove static keyword
    @Value("${spring.mail.username}")
    private String FROM_MAIL;

    @Autowired private VehicleRepository vehiclerepository;
    @Autowired private PolicyRepository policyrepository;

    @Override
    public Iterable<Vehicle> SelectAllVehicle() {
        return vehiclerepository.findAll();
    }

    @Override
    public void RemoveVehicleById(int vehicleid) {
        vehiclerepository.deleteById(vehicleid);
    }

    @Override
    public Vehicle UpdateVehicleData(Vehicle vehicle, int vehicleid) {
        vehiclerepository.findById(vehicleid);
        return vehiclerepository.save(vehicle);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public Customer getSingleCustomerById(int customerId) {
        return repository.findById(customerId)
                .orElseThrow(() -> new InvalidCustomerIdException("Customer id " + customerId + " is not valid"));
    }

    @Override
    public Customer updateCustomer(Customer customer, int customerId) {
        Optional<Customer> customerRef = repository.findById(customerId);
        if (customerRef.isPresent()) {
            return repository.save(customer);
        } else {
            throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        if (repository.existsById(customerId)) {
            repository.deleteById(customerId);
        } else {
            throw new InvalidCustomerIdException("Customer id " + customerId + " is not valid");
        }
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
        return policyrepository.findById(policyId)
                .orElseThrow(() -> new InvalidCustomerIdException("Policy id " + policyId + " is not valid"));
    }

    @Override
    public Policy updatePolicyById(Policy policy) {
        return policyrepository.save(policy);
    }

    @Override
    public void deletePolicyByPolicyId(int policyId) {
        policyrepository.deleteById(policyId);
    }

    public Document uploadDocuments(String documentJson, MultipartFile pancard, MultipartFile adharcard, MultipartFile profile,
            MultipartFile vehicleRc, MultipartFile vehicle) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            Document document = mapper.readValue(documentJson, Document.class);
            document.setPancardImage(pancard.getBytes());
            document.setAdharcardImgae(adharcard.getBytes());
            document.setProfileImage(profile.getBytes());
            document.setVehicleRcImage(vehicleRc.getBytes());
            document.setVehicleImage(vehicle.getBytes());
            return documentRepository.save(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Document getSingleDocumentDetails(int documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> new DocumentsNotFoundByIdException("Documents Not Found on Id-" + documentId));
    }

    @Override
    public void deleteDocumentById(int documentId) {
        documentRepository.deleteById(documentId);
    }

    @Override
    public Document updateDocumentDetails(String documentJson, MultipartFile pancard, MultipartFile adharcard,
            MultipartFile profile, MultipartFile vehicleRc, MultipartFile vehicle) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Document document = mapper.readValue(documentJson, Document.class);
            document.setPancardImage(pancard.getBytes());
            document.setAdharcardImgae(adharcard.getBytes());
            document.setProfileImage(profile.getBytes());
            document.setVehicleRcImage(vehicleRc.getBytes());
            document.setVehicleImage(vehicle.getBytes());
            return documentRepository.save(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer saveCustomers(MultipartFile profile, MultipartFile pancard, MultipartFile adharcard, String jsondata,
            MultipartFile vehicalPhoto, MultipartFile rcBook) {

        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        try {
            customer = mapper.readValue(jsondata, Customer.class);
            String fivechar = customer.getCustomerFirstName().substring(0, 4);
            customer.setCustomerUsername(Utility.genrateUsername(fivechar));
            customer.setCustomerPassword(Utility.genratePassword(fivechar));

            customer.setProfileImage(profile.getBytes());
            customer.setPancardImage(pancard.getBytes());
            customer.setAdharcardImgae(adharcard.getBytes());

            // Initialize the vehicle list if it's null or empty
            if (customer.getVehicle() == null) {
                customer.setVehicle(new ArrayList<>());
            }

            if (customer.getVehicle().isEmpty()) {
                customer.getVehicle().add(new Vehicle());
            }

            // Set vehicle images
            customer.getVehicle().get(0).setVehicleImage(vehicalPhoto.getBytes());
            customer.getVehicle().get(0).setVehicleRcImage(rcBook.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ensure FROM_MAIL and customer email are not null
        if (FROM_MAIL != null && customer.getCustomerEmailId() != null) {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(FROM_MAIL);
            msg.setTo(customer.getCustomerEmailId());
            msg.setSubject("Your Account is Created");
            msg.setText("Username: " + customer.getCustomerUsername() + "\nPassword: " + customer.getCustomerPassword());
            mailsender.send(msg);
        }

        return repository.save(customer);
    }

    @Override
    public Vehicle insertdataofcustomer(MultipartFile vehiclephoto, MultipartFile rcphoto) {
        Vehicle vehicle = new Vehicle();
        try {
            vehicle.setVehicleImage(vehiclephoto.getBytes());
            vehicle.setVehicleRcImage(rcphoto.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return vehiclerepository.save(vehicle);
    }

	@Override
	public List<Document> getAllDocumentsDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}
