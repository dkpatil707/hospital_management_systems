package com.ty.HospitalManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HospitalManagementSystem.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
