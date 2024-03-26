package com.ty.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.MedItems;
import com.ty.HospitalManagementSystem.dto.Medorder;
import com.ty.HospitalManagementSystem.repo.MedItemRepo;

@Repository
public class MedItemsdao {

	@Autowired
	private MedItemRepo repo;

	@Autowired
	private Medorderdao medorderdao;

	public MedItems saveMedItems(MedItems medItems, int mid) {
		Medorder medorder = medorderdao.getmedorderbyid(mid);
		medItems.setMedorder(medorder);
		return repo.save(medItems);

	}

	public MedItems updateMedItems(int id, MedItems medItems) {
		if (repo.findById(id).isPresent()) {
			medItems.setId(id);
			return repo.save(medItems);
		} else {
			return null;
		}

	}

	public MedItems deletemedItems(int id) {
		if (repo.findById(id).isPresent()) {
			MedItems meditems = repo.findById(id).get();
			repo.deleteById(id);
			return meditems;
		} else {
			return null;
		}

	}

	public MedItems getMedItemsbyid(int id) {
		return repo.findById(id).get();

	}
}
