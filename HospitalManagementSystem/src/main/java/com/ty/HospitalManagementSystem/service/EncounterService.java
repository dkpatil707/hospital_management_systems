package com.ty.HospitalManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.Branchdao;
import com.ty.HospitalManagementSystem.dao.Encounterdao;
import com.ty.HospitalManagementSystem.dao.Persondao;
import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.dto.Encounter;
import com.ty.HospitalManagementSystem.dto.Person;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private Encounterdao encounterdao;

	@Autowired
	private Persondao persondao;

	@Autowired
	private Branchdao branchdao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = persondao.getpersonbyid(pid);
		Branch branch = branchdao.getbranchbyid(bid);

		encounter.setPerson(person);
		List<Branch> list = new ArrayList<>();
		list.add(branch);
		encounter.setList(list);
		
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("succesfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterdao.saveEncounter(encounter));
		
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Encounter>> updatEncounter(int id, Encounter encounter, int bid) {
		Encounter dbencounter = encounterdao.getencounterbyid(id);
		Branch branch = branchdao.getbranchbyid(bid);

		List<Branch> branchs = dbencounter.getList();
		encounter.setList(dbencounter.getList());
		encounter.setPerson(dbencounter.getPerson());
		
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("succesfully updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterdao.updateEncounter(id, encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		Encounter encounter=encounterdao.deleteEncounter(id);
		if(encounter!=null) {
			ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("succesfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
		
	}
	public ResponseEntity<ResponseStructure<Encounter>> getencounterbyid(int id) {
		Encounter encounter=encounterdao.getencounterbyid(id);
		if(encounter!=null) {
			ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("succesfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.FOUND);
		}else {
			return null;
		}
		
	}
}
