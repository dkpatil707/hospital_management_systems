package com.ty.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Encounter;
import com.ty.HospitalManagementSystem.dto.Medorder;
import com.ty.HospitalManagementSystem.repo.MedOrderRepo;

@Repository
public class Medorderdao {

	@Autowired
	private MedOrderRepo medOrderRepo;
	
	@Autowired
	private Encounterdao encounterdao;
	
	public Medorder saveMedorder(Medorder medorder,int eid) {
		Encounter encounter=encounterdao.getencounterbyid(eid);
		medorder.setEncounter(encounter);
		return medOrderRepo.save(medorder);
		
	}
	public Medorder updateMedorder(int id,Medorder medorder) {
		if(medOrderRepo.findById(id).isPresent()) {
			medorder.setId(id);
			return medOrderRepo.save(medorder);
		}else {
			return null;
		}
		
	}
	public Medorder deletemedorder(int id) {
		if(medOrderRepo.findById(id).isPresent()) {
			Medorder medorder=medOrderRepo.findById(id).get();
			medOrderRepo.deleteById(id);
			return medorder;
		}else {
			return null;
		}
		
	}
	public Medorder getmedorderbyid(int id) {
		return medOrderRepo.findById(id).get();
		
	}
}
