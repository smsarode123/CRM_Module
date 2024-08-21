package com.insurance.registrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.registrationservice.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer>{

}
