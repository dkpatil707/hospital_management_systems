package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.MedItemsdao;
import com.ty.HospitalManagementSystem.dto.MedItems;

@Service
public class MedItemService {

	@Autowired
	private MedItemsdao medItemsdao;

	public MedItems saveMedItems(int mid, MedItems meditems) {
		return medItemsdao.saveMedItems(meditems, mid);
	}

	public MedItems updateMedItems(int id, MedItems meditems) {
		MedItems medItems2 = medItemsdao.getMedItemsbyid(id);
		meditems.setMedorder(medItems2.getMedorder());
		MedItems daoMedItems = medItemsdao.updateMedItems(id, meditems);
		if (daoMedItems != null) {
			return daoMedItems;
		} else {
			return null;
		}
	}

	public MedItems deleteMedItems(int id) {
		MedItems meditems = medItemsdao.deletemedItems(id);
		if (meditems != null) {
			return meditems;
		} else {
			return null;
		}

	}

	public MedItems getmeditemsbyid(int id) {
		MedItems meditems = medItemsdao.getMedItemsbyid(id);
		if (meditems != null) {
			return meditems;
		} else {
			return null;
		}

	}
}
