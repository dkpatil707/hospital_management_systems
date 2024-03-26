package com.ty.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Encounter;
import com.ty.HospitalManagementSystem.repo.EnconuterRepo;

@Repository
public class Encounterdao {

	@Autowired
	private EnconuterRepo repo;

	public Encounter saveEncounter(Encounter encounter) {
		return repo.save(encounter);

	}

	public Encounter updateEncounter(int id, Encounter encounter) {
		if (repo.findById(id).isPresent()) {
			encounter.setId(id);
			return repo.save(encounter);
		} else {
			return null;
		}

	}

	public Encounter deleteEncounter(int id) {
		if (repo.findById(id).isPresent()) {
			Encounter encounter = repo.findById(id).get();
			repo.deleteById(id);
			return encounter;
		} else {
			return null;
		}

	}

	public Encounter getencounterbyid(int id) {
		return repo.findById(id).get();

	}
}
