package com.insurance.registrationservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
	@Lob
	@Column(length=999999999)
	private byte[] customerPhotograph;
	private String vehicleRc;
	@Lob
	@Column(length=999999999)
	private byte[] vehicleImage;

}
