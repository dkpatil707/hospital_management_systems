package com.ty.HospitalManagementSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Hospital;
import com.ty.HospitalManagementSystem.service.HospitalService;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;

	@ApiOperation(value = "save hospital", notes = "api is used to save hospital")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully saved") })
	@PostMapping("/savehospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return service.saveHospital(hospital);

	}

	@ApiOperation(value = "update hospital", notes = "api is used to update hospital")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "updated succesfully"),
			@ApiResponse(code = 404, message = "id not found") })
	@PutMapping("/updatehospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@Valid @RequestParam int id,
			@RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);

	}

	@ApiOperation(value = "delete hospital", notes = "api is used to delete hospital")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "id not found") })
	@DeleteMapping("/deletehospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@Valid @RequestParam int id) {
		return service.deleteHospital(id);

	}

	@ApiOperation(value = "get hospital by id", notes = "api is used to fetch the hospital based on id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "succesfully found"),
			@ApiResponse(code = 404, message = "id not found") })
	@GetMapping("/gethospitalbyid")
	public ResponseEntity<ResponseStructure<Hospital>> gethospitalbyid(@Valid @RequestParam int id) {
		return service.getHospitalbyid(id);

	}

	@ApiOperation(value = "get hospital by email", notes = "api is used to fetch the hospital based on email")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "succesfully found"),
			@ApiResponse(code = 404, message = "email not found") })
	@GetMapping("/gethospitalbyemail")
	public Hospital gethospitalbyemail(@Valid @RequestParam String email) {
		return service.gethospitalbyemail(email);

	}
}
