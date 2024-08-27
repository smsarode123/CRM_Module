package com.insurance.registrationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.registrationservice.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

	public List<Document> deleteByDocumentId(int documentId);
}
