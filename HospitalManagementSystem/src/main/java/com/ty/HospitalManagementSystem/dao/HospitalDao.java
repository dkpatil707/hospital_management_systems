package com.ty.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Hospital;
import com.ty.HospitalManagementSystem.repo.HospitalRepo;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepo hospitalRepo;

	public Hospital savehospital(Hospital hospital) {
		return hospitalRepo.save(hospital);

	}

	public Hospital updatehospital(int id, Hospital hospital) {
		if (hospitalRepo.findById(id).isPresent()) {
			hospital.setId(id);
			return hospitalRepo.save(hospital);
		} else {
			return null;
		}

	}

	public Hospital deletehospital(int id) {
		if (hospitalRepo.findById(id).isPresent()) {
			Hospital hospital = hospitalRepo.findById(id).get();
			hospitalRepo.deleteById(id);
			return hospital;
		} else {
			return null;

		}

	}

	public Hospital gethospitalbyid(int id) {
		Optional<Hospital> hospital=hospitalRepo.findById(id);
		if(hospital.isPresent()) {
			return hospital.get();
		}else {
			return null;
		}

	}

	public List<Hospital> getallHospitals() {
		return hospitalRepo.findAll();

	}

	public Hospital gethospitalbyemail(String email) {
		return hospitalRepo.findhospitalbyemail(email);

	}
}
