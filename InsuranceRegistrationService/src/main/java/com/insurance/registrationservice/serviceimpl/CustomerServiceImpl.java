package com.insurance.registrationservice.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.registrationservice.exceptions.DocumentsNotFoundByIdException;
import com.insurance.registrationservice.exceptions.DocumentsNotUploadException;
import com.insurance.registrationservice.exceptions.DocumentsNotUploadedYetException;
import com.insurance.registrationservice.model.Customer;
import com.insurance.registrationservice.model.Document;
import com.insurance.registrationservice.repository.CustomerRepository;
import com.insurance.registrationservice.repository.DocumentRepository;
import com.insurance.registrationservice.service.CustomerServiceI;
@Service
public class CustomerServiceImpl implements CustomerServiceI{
	
	@Autowired private CustomerRepository repository;

	@Autowired private DocumentRepository documentRepository;
	
	

	@Override
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
