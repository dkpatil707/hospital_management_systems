package com.ty.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Encounter;
import com.ty.HospitalManagementSystem.service.EncounterService;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@RestController
public class EncounterController {
	
	@Autowired
	private EncounterService service;

	@PostMapping("/saveencounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,@RequestParam int pid,@RequestParam int bid) {
		return service.saveEncounter(encounter, pid, bid);
		
	}
	@PutMapping("/updateencounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestParam int id,@RequestBody Encounter encounter,@RequestParam int bid) {
		return service.updatEncounter(id, encounter, bid);
	}
	
	@DeleteMapping("/deletencounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int id) {
		return service.deleteEncounter(id);
		
	}
	
	@GetMapping("/getencounterbyid")
	public ResponseEntity<ResponseStructure<Encounter>> getencounterbyid(@RequestParam int id) {
		return service.getencounterbyid(id);
	}
}
