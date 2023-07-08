package com.global.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.app.entity.DoctorDepartment;
import com.global.app.entity.DoctorDetails;
import com.global.app.service.IDoctorAndDepartmentService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Slf4j
public class DoctorAndDepartmentRestController {
	
	@Autowired
	private IDoctorAndDepartmentService doctorAndDepartmentService;
	
	@GetMapping("/departmentForAppointment")
	public List<DoctorDepartment> allDepartment(){
		return doctorAndDepartmentService.getAllDepartment();
		
	}
	
	@GetMapping("/doctorForAppointment")
	public List<DoctorDetails> allDoctor(){
		return doctorAndDepartmentService.allDoctorDetailss();
		
	}
	
	@GetMapping("/doctorForAppointment/{dId}")
	public List<DoctorDetails> allDoctorByDepartmentId(@PathVariable Integer dId ){
		return doctorAndDepartmentService.getAllDoctorDetailss(dId);
		
	}

}
