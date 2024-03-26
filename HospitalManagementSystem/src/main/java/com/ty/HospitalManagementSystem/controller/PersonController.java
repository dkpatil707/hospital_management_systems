package com.ty.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Person;
import com.ty.HospitalManagementSystem.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping("/saveperson")
	public Person savePerson(@RequestBody Person person) {
		return service.savePerson(person);

	}

	@PutMapping("/updateperson")
	public Person updatePerson(@RequestParam int id, @RequestBody Person person) {
		return service.updatePerson(id, person);

	}

	@DeleteMapping("/deleteperson")
	public Person deletePerson(@RequestParam int id) {
		return service.deletePerson(id);

	}

	@GetMapping("/getpersonbyid")
	public Person getpersonbyid(@RequestParam int id) {
		return service.getpersonbyid(id);

	}
}
