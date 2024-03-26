package com.ty.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.MedItems;
import com.ty.HospitalManagementSystem.service.MedItemService;

@RestController
public class MeditemController {

	@Autowired
	private MedItemService service;
	
	@PostMapping("/savemeditems")
	public MedItems saveMedItems(@RequestParam int mid,@RequestBody MedItems meditems) {
		return service.saveMedItems(mid, meditems);
	}
	@PutMapping("/updatemeditems")
	public MedItems updateMedItems(@RequestParam int id,@RequestBody MedItems meditems) {
		return service.updateMedItems(id, meditems);
	}
	@DeleteMapping("/deletemeditems")
	public MedItems deleteMedItems( @RequestParam int id) {
		return service.deleteMedItems(id);
		
	}
	@GetMapping("/getmeditemsbyid")
	public MedItems getmeditemsbyid(@RequestParam int id) {
		return service.getmeditemsbyid(id);
	}
}
