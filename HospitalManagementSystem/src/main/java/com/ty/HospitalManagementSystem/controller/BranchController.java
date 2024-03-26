package com.ty.HospitalManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.service.BranchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Validated
public class BranchController {

	@Autowired
	private BranchService service;
	
	@ApiOperation(value = "Save Branch",notes = "Api is used to save branch")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully saved")})
	@PostMapping("/savebranch")
	public Branch saveBranch(@Valid @RequestBody Branch branch, @RequestParam int hid,@RequestParam int aid) {
		return service.saveBranch(hid, aid, branch);
	}
	@PutMapping("/updatebranch")
	public Branch updateBranch(@RequestParam int id,@RequestBody Branch branch) {
		return service.updateBranch(id, branch);
	}
	@DeleteMapping("/deletebranch")
	public Branch deleteBranch(@RequestParam int id) {
		return service.deleteBranch(id);
		
	}
	@GetMapping("/getbranchbyid")
	public Branch getbranchbyid( @RequestParam int id) {
		return service.getbranchbyid(id);
		
	}
	@GetMapping("/getbranchbyhospitalid")
	public List<Branch> getbranchbyhospitalid(@RequestParam int hid) {
		return service.getbranchbyhospitalid(hid);
	}
}
