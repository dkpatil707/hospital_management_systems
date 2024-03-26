package com.ty.HospitalManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HospitalManagementSystem.dto.Medorder;

public interface MedOrderRepo extends JpaRepository<Medorder, Integer>{

}
