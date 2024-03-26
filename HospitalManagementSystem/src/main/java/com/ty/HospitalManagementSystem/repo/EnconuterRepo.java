package com.ty.HospitalManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HospitalManagementSystem.dto.Encounter;

public interface EnconuterRepo extends JpaRepository<Encounter, Integer>{

}
