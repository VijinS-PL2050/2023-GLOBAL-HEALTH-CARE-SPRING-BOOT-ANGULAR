package com.global.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.entity.DoctorDepartment;
import com.global.app.entity.DoctorDetails;
import com.global.app.repo.IDepartmentRepo;
import com.global.app.repo.IDoctorRepo;

@Service
public class DoctorAndDepartmentServiceImple implements IDoctorAndDepartmentService {

	private IDoctorRepo docRepo;

	private IDepartmentRepo depRepo;

	@Autowired
	public DoctorAndDepartmentServiceImple(IDoctorRepo docRepo, IDepartmentRepo depRepo) {
		super();
		this.docRepo = docRepo;
		this.depRepo = depRepo;
	}

	@Override
	public List<DoctorDetails> getAllDoctorDetailss(Integer deptId) {
		return docRepo.getAllDoctorDetailss(deptId);
	}

	@Override
	public List<DoctorDepartment> getAllDepartment() {

		return depRepo.allDepartment();
	}

	@Override
	public DoctorDetails getDoctorDetails(Integer doId) {
		return docRepo.findById(doId).orElseThrow(() -> new RuntimeException("Doctor not found for " + doId));
	}

	@Override
	public void updateForToken(DoctorDetails doctorDetails) {
		docRepo.save(doctorDetails);

	}

	@Override
	public List<DoctorDetails> allDoctorDetailss() {
		
		return docRepo.allDoctorDetailss();
	}

	@Override
	public DoctorDepartment getDoctorDepartment(Integer getdId) {

		return depRepo.findById(getdId).orElseThrow(() -> new RuntimeException("Department not found for " + getdId));
	}

	@Override
	public DoctorDetails getDoctorDetailsByuId(Integer uId) {
		// TODO Auto-generated method stub
		return docRepo.getDoctorByuId(uId);
	}

}
