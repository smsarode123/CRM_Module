package com.insurance.registrationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int DocumentId;
	private Long customerAdharCard;
	private String customerPancard;
	private String customerPhotograph;
	private String vehicleRc;
	private String vehicleImage;

}
