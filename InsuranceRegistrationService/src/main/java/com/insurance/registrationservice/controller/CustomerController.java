package com.insurance.registrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.registrationservice.service.CustomerServiceI;

@RestController
public class CustomerController {

	@Autowired CustomerServiceI csi;
	

}
