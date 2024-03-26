package com.ty.HospitalManagementSystem.exception;

import java.io.ObjectInputStream.GetField;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.HospitalManagementSystem.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idnotfoundexception(IdNotFoundException exception) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("id not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> nosuchelementexception(NoSuchElementException exception) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("no element found for this given id");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<>();
		for(ObjectError error:errors) {
			String fieldname=((FieldError)error).getField();
			String message=((FieldError)error).getDefaultMessage();
			map.put(fieldname, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> handleConstraintViolationException
	(ConstraintViolationException exception) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData("this field should not be null or blank");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
		
		
	}
}
