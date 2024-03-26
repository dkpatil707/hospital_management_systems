package com.ty.HospitalManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.HospitalManagementSystem.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>{

	@Query("select h from Hospital h where h.email=?1")
	public Hospital findhospitalbyemail(String email) ;
		
	}

