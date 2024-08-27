package com.insurance.registrationservice.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int documentId;
	
	@Lob
	@Column(length = 999999999)
	private byte [] pancardImage;

	@Lob
	@Column(length = 999999999)
	private byte [] adharcardImgae;

	@Lob
	@Column(length = 999999999)
	private byte [] profileImage;
	
	@Lob
	@Column(length = 999999999)
	private byte [] vehicleRcImage;

	@Lob
	@Column(length = 999999999)
	private byte [] vehicleImage;

	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", pancardImage=" + Arrays.toString(pancardImage)
				+ ", adharcardImgae=" + Arrays.toString(adharcardImgae) + ", profileImage="
				+ Arrays.toString(profileImage) + ", vehicleRcImage=" + Arrays.toString(vehicleRcImage)
				+ ", vehicleImage=" + Arrays.toString(vehicleImage) + "]";
	}


}
