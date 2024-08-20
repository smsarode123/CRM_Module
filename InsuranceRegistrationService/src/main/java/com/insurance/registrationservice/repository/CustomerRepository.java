package com.insurance.registrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.registrationservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
