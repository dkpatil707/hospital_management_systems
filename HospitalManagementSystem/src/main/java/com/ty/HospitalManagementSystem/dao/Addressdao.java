package com.ty.HospitalManagementSystem.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Address;
import com.ty.HospitalManagementSystem.repo.AddressRepo;

@Repository
public class Addressdao {

	@Autowired
	private AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
		
	}
	public Address updateAddress(int id,Address address) {
		if(addressRepo.findById(id).isPresent()) {
			address.setId(id);
			return addressRepo.save(address);
		}else {
			return null;
		}
		
	}
	public Address deleteAddress(int id) {
		if(addressRepo.findById(id).isPresent()) {
			Address address=addressRepo.findById(id).get();
			addressRepo.deleteById(id);
			return address;
		}else {
			return null;
		}
		
	}
	public Address getaddressbyid(int id) {
		if(addressRepo.findById(id).isPresent()) {
			return addressRepo.findById(id).get();
			
		}else {
			return null;
		}
		
	}
	
	
}
