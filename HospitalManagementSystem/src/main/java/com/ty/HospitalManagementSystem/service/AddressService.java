package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.Addressdao;
import com.ty.HospitalManagementSystem.dto.Address;

@Service
public class AddressService {

	@Autowired
	private Addressdao addressdao;
	
	public Address saveAddress(Address address) {
		return addressdao.saveAddress(address);
		
	}
	public Address updateAddress(int id,Address address) {
		Address dbaddress=addressdao.updateAddress(id, address);
		if(dbaddress!=null) {
			return dbaddress;
		}else {
			return null;
		}
		
	}
	public Address deleteAddress(int id) {
		Address address=addressdao.deleteAddress(id);
		if(address!=null) {
			return address;
		}else {
			return null;
		}
		
	}
	public Address getaddressbyid(int id) {
		Address address=addressdao.getaddressbyid(id);
		if(address!=null) {
			return address;
		
	}else {
		return null;
	}
	}
}
