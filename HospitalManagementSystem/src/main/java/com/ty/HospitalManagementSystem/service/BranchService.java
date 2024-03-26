package com.ty.HospitalManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.Branchdao;
import com.ty.HospitalManagementSystem.dto.Branch;

@Service
public class BranchService {

	@Autowired
	private Branchdao branchdao;

	public Branch saveBranch(int hid, int aid, Branch branch) {
		return branchdao.saveBranch(hid, aid, branch);

	}

	public Branch updateBranch(int id, Branch branch) {
		Branch dbbranch = branchdao.updateBranch(id, branch);
		if (dbbranch != null) {
			return dbbranch;
		} else {
			return null;
		}

	}

	public Branch deleteBranch(int id) {
		Branch branch = branchdao.deleteBranch(id);
		if (branch != null) {
			return branch;
		} else {
			return null;
		}

	}

	public Branch getbranchbyid(int id) {
		Branch branch = branchdao.getbranchbyid(id);
		if (branch != null) {
			return branch;
		} else {
			return null;
		}

	}

	public List<Branch> getbranchbyhospitalid(int hid) {
		List<Branch> branchs = branchdao.getbranchbyhospitalid(hid);
		if (branchs != null) {
			return branchs;
		} else {
			return null;
		}

	}
}
