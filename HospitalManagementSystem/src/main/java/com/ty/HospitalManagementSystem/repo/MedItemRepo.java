package com.ty.HospitalManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HospitalManagementSystem.dto.MedItems;

public interface MedItemRepo extends JpaRepository<MedItems, Integer>{

}
