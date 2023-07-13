package com.global.app.service;

import java.util.List;

import com.global.app.entity.DoctorDepartment;
import com.global.app.entity.DoctorDetails;

public interface IDoctorAndDepartmentService {
	
	public List<DoctorDetails> getAllDoctorDetailss(Integer deptId);
	public List<DoctorDepartment> getAllDepartment();
	public DoctorDetails getDoctorDetails(Integer doId);
	public void updateForToken(DoctorDetails doctorDetails);
	public List<DoctorDetails> allDoctorDetailss();
	public DoctorDepartment getDoctorDepartment(Integer getdId);
	public DoctorDetails getDoctorDetailsByuId(Integer uId);
}
