package com.insurance.registrationservice.exceptions;

public class DocumentsNotFoundByIdException extends RuntimeException{

	public DocumentsNotFoundByIdException(String msg) {
		super(msg);
	}
}
