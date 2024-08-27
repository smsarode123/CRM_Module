package com.insurance.registrationservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	

	private String message;
	private String className;
	private Date responseDate;
	private int statusCode;
	

}