package com.ty.HospitalManagementSystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "state cannot be null")
	private String state;
	@NotNull(message = "city cannot be null")
	private String city;
	@NotNull(message = "pincode cannot be null")
	private long pincode;
	
}
