package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.Medorderdao;
import com.ty.HospitalManagementSystem.dto.Medorder;

@Service
public class MedOrdrService {

	@Autowired
	private Medorderdao medorderdao;
	
	public Medorder saveMedorder(int eid,Medorder medorder) {
		return medorderdao.saveMedorder(medorder, eid);
		
	}
	public Medorder updateMedorder(int id,Medorder medorder) {
		Medorder dbMedorder=medorderdao.getmedorderbyid(id);
		medorder.setEncounter(dbMedorder.getEncounter());
		Medorder daoMedorder=medorderdao.updateMedorder(id, medorder);
		if(daoMedorder!=null) {
			return daoMedorder;
		}else {
			return null;
		}
		
	}
	public Medorder deleteMedorder(int id) {
		Medorder medorder=medorderdao.deletemedorder(id);
		if(medorder!=null) {
			return medorder;
		}else {
			return null;
		}
		
	}
	public Medorder getMedorderbyid(int id) {
		Medorder medorder=medorderdao.getmedorderbyid(id);
		if(medorder!=null) {
			return medorder;
		}else {
			return null;
		}
		
	}
}
