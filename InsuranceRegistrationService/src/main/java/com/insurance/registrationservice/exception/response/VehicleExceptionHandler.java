package com.insurance.registrationservice.exception.response;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.insurance.registrationservice.dto.ErrorResponse;
import com.insurance.registrationservice.exception.InvalidCustomerIdException;
import com.insurance.registrationservice.exception.InvalidVehicleIdException;



@RestControllerAdvice
public class VehicleExceptionHandler {
	
	@ExceptionHandler(InvalidVehicleIdException.class)
	public ResponseEntity<ErrorResponse> handlerInvalidVehicleId(InvalidVehicleIdException veh)
	{
		ErrorResponse response = new ErrorResponse(veh.getMessage(),veh.getClass().getName(),new Date(), 404);
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(InvalidCustomerIdException.class)
	public ResponseEntity<ErrorResponse> handlerInvalidCustomerId(InvalidCustomerIdException cus)
	{
		ErrorResponse response = new ErrorResponse(cus.getMessage(),cus.getClass().getName(),new Date(), 404);
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}

