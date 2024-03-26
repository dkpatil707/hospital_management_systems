package com.ty.HospitalManagementSystem.exception;

public class IdNotFoundException extends RuntimeException{

	private String message="Id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFoundException(String message) {
		this.message = message;
	}

	public IdNotFoundException() {
		super();
	}
	
	
	
	
	
}
