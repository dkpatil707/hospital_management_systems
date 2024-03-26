package com.ty.HospitalManagementSystem.service;

import java.util.NoSuchElementException;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.HospitalDao;
import com.ty.HospitalManagementSystem.dto.Hospital;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("succesfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.savehospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		Hospital dbhospital = dao.updatehospital(id, hospital);
		if (dbhospital != null) {
			ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("succesfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbhospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id not found for hospital");
		}

	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		Hospital hospital = dao.deletehospital(id);
		if (hospital != null) {
			ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id not found for given hospital id");
		}

	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalbyid(int id) {
		Hospital hospital = dao.gethospitalbyid(id);
		if (hospital != null) {
			ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("succesfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("no id found");
		}

	}

	public Hospital gethospitalbyemail(String email) {
		Hospital hospital = dao.gethospitalbyemail(email);
		if (hospital != null) {
			return hospital;
		} else {
			return null;
		}

	}
}
