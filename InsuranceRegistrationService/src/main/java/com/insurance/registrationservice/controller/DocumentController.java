package com.insurance.registrationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.insurance.registrationservice.exceptions.DocumentsNotFoundByIdException;
import com.insurance.registrationservice.exceptions.DocumentsNotUploadException;
import com.insurance.registrationservice.exceptions.DocumentsNotUploadedYetException;
import com.insurance.registrationservice.model.Document;
import com.insurance.registrationservice.service.CustomerServiceI;

@RestController
public class DocumentController {
	
	@Autowired private CustomerServiceI customerServiceI;
	

	
	@PostMapping("/upload_Document_Details")
	public ResponseEntity<Document> uploadDetails(@RequestPart("data") String documentJson,
			                                      @RequestPart("pancard") MultipartFile pancard,
			                                      @RequestPart("adharcard") MultipartFile adharcard,
			                                      @RequestPart("profile") MultipartFile profile,
			                                      @RequestPart("vehicleRc") MultipartFile vehicleRc,
			                                      @RequestPart("vehicle") MultipartFile vehicle)
	{
	
		Document docRef=customerServiceI.uploadDocuments(documentJson, pancard, adharcard, profile, vehicleRc, vehicle);
		return new ResponseEntity<Document>(docRef, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get_All_Document_Details")
	public ResponseEntity<List<Document>> getAllDocumentsDetails()
	{
		List<Document> docList=customerServiceI.getAllDocumentsDetails();
		return new ResponseEntity<List<Document>>(docList, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(DocumentsNotUploadedYetException.class)
	public ResponseEntity<String> handleDocumentsNotUploadedYet(DocumentsNotUploadedYetException exception)
	{
	return new ResponseEntity<String>(exception.toString(), HttpStatus.NOT_FOUND);	
	}
	
	@GetMapping("/get_Single_Document_Details/{documentId}")
	public ResponseEntity<Document> getSingleDocumentDetails(@PathVariable int documentId)
	{
		Document docRef=customerServiceI.getSingleDocumentDetails(documentId);
		return new ResponseEntity<Document>(docRef, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(DocumentsNotFoundByIdException.class)
	public ResponseEntity<String> handleDocumetsNotFoundById(DocumentsNotFoundByIdException exception)
	{
		return new ResponseEntity<String>(exception.toString(), HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delete_Document_Details_By_Id/{documentId}")
	public ResponseEntity<String> deleteDocumentById(@PathVariable int documentId)
	{
	  customerServiceI.deleteDocumentById(documentId);
		return new ResponseEntity<String>("Document deleted successfully using id", HttpStatus.OK);
	}
	
	@PutMapping("update_Document_Details_By_Id/{documentId}")
	public ResponseEntity<Document> updateDocumentDetails(@PathVariable int documentId,@RequestPart("data") String documentJson,
                                                          @RequestPart("pancard") MultipartFile pancard,
                                                          @RequestPart("adharcard") MultipartFile adharcard,
                                                          @RequestPart("profile") MultipartFile profile,
                                                          @RequestPart("vehicleRc") MultipartFile vehicleRc,
                                                          @RequestPart("vehicle") MultipartFile vehicle)
	{
		Document docRef=customerServiceI.updateDocumentDetails(documentJson, pancard, adharcard, profile, vehicleRc, vehicle);
		return new ResponseEntity<Document>(docRef, HttpStatus.OK);
	}
	
	
}
