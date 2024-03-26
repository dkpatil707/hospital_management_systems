package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.Persondao;
import com.ty.HospitalManagementSystem.dto.Person;

@Service
public class PersonService {

	@Autowired
	private Persondao persondao;

	public Person savePerson(Person person) {
		return persondao.savePerson(person);

	}

	public Person updatePerson(int id, Person person) {
		Person dbperson = persondao.updatePerson(id, person);
		if (dbperson != null) {
			return dbperson;
		} else {
			return null;
		}

	}

	public Person deletePerson(int id) {
		Person person = persondao.deletePerson(id);
		if (person != null) {
			return person;
		} else {
			return null;
		}

	}

	public Person getpersonbyid(int id) {
		Person person = persondao.getpersonbyid(id);
		if (person != null) {
			return person;
		} else {
			return null;
		}

	}
}
