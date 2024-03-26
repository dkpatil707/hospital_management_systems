package com.ty.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Medorder;
import com.ty.HospitalManagementSystem.service.MedOrdrService;

@RestController
public class MedOrderController {

	@Autowired
	private MedOrdrService service;
	
	@PostMapping("/savemedorder")
	public Medorder saveMedorder(@RequestParam int eid,@RequestBody Medorder medorder) {
		return service.saveMedorder(eid, medorder);
		
	}
	@PutMapping("/updatemedorder")
	public Medorder updateMedorder(@RequestParam int id,@RequestBody Medorder medorder) {
		return service.updateMedorder(id, medorder);
		
	}
	@DeleteMapping("/deletemedorder")
	public Medorder deleteMedorder(@RequestParam int id) {
		return service.deleteMedorder(id);
	}
	@GetMapping("/getmedorderbyid")
	public Medorder getmedorderbyid( @RequestParam int id) {
		return service.getMedorderbyid(id);
		
	}
}
