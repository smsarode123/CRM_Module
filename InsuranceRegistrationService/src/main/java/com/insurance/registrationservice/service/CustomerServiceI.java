package com.insurance.registrationservice.service;



import java.util.List;

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

}
