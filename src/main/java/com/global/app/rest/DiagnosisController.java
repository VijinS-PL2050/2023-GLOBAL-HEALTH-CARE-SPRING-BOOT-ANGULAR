package com.global.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.app.entity.Diagnosis;
import com.global.app.entity.Dosage;
import com.global.app.entity.MedicinesStock;
import com.global.app.entity.PatientRecords;
import com.global.app.entity.TestPrescription;
import com.global.app.entity.Tests;
import com.global.app.service.IAppointmentService;
import com.global.app.service.IDiagnosisService;
import com.global.app.service.IPatientService;
import com.global.app.service.ITokenGeneratorService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class DiagnosisController {
	@Autowired
	private IDiagnosisService diagnosisservice;

	@Autowired
	private ITokenGeneratorService tokenGeneratorService;

	@Autowired
	private IAppointmentService appointmentService;

	@Autowired
	private IPatientService patientService;

	// listing diagnosis
	@GetMapping("/diagnosis/{pId}")
	public List<Diagnosis> getDiagnosis(@PathVariable Integer pId) {
		return diagnosisservice.getDiagnosis(pId);
	}

	// Listing diagnosis by diId
	@GetMapping("/diagnosisbydId/{diId}")
	public List<Diagnosis> getDiagnosisBydiId(@PathVariable Integer diId) {
		System.out.println(diId);
		return diagnosisservice.getDiagnosisBydiId(diId);
	}
	// listing by uId

	@GetMapping("/diagnosisbyuId/{uId}")
	public List<Diagnosis> getDiagnosisByuId(@PathVariable Integer uId) {
		System.out.println(uId);
		return diagnosisservice.getDiagnosisByuId(uId);
	}

	// add diagnosis
	@PostMapping("/diagnosis")
	public void addDiagnosis(@RequestBody Diagnosis diagnosis) {
		System.out.println(" post mapping ");
		System.out.println(diagnosis.toString());
		Integer aId = tokenGeneratorService.getToken(diagnosis.getTId()).getAId();
		Integer pId = appointmentService.getAppointment(aId).getPId();
		diagnosis.setPId(pId);
		diagnosisservice.saveDiagnosis(diagnosis); // save for add and update

	}

	@GetMapping("/diagnosishistory")
	public List<Diagnosis> allDiagnosisHistory() {

		return diagnosisservice.allDiagnosisHistory();
	}

	@GetMapping("/diagnosishistory/{tId}")
	public List<Diagnosis> diagnosisHistoryByPId(@PathVariable Integer tId) {
		System.out.println(" dia histroy  " + tId);
		Integer aId = tokenGeneratorService.getToken(tId).getAId();
		Integer pId = appointmentService.getAppointment(aId).getPId();
		System.out.println(" p i d " + pId);
		return diagnosisservice.diagnosisHistoryByPId(pId);
	}

	@GetMapping("/getPatientByTId/{tId}")
	public PatientRecords getPatientByTId(@PathVariable Integer tId) {
		System.out.println("i m in");
		Integer aId = tokenGeneratorService.getToken(tId).getAId();
		Integer pId = appointmentService.getAppointment(aId).getPId();
		return patientService.getPatientRecords(pId);

	}
	
	@GetMapping("/getAllMedicine")
	public List<MedicinesStock> getAllMedicine(){
		return diagnosisservice.allMedicine();
		
	}
	
	
	@GetMapping("/getAllDosage")
	public List<Dosage> getAllDosage(){
		return diagnosisservice.allDosages();
	}
	
	@GetMapping("/getDiagnosisIdBytId/{tId}")
	public Integer getDiagnosisIdBytId(@PathVariable Integer tId) {
		return diagnosisservice.getDidByTid(tId);
		
	}
	@GetMapping("/getAllTest")
	public List<Tests>getAllTest() {
	
		return diagnosisservice.AllTest();
	}
	// update diagnosis
	@PutMapping("/updatediagnosis")
	public void updateDiagnosis(@RequestBody Diagnosis diagnosis) {
		diagnosisservice.saveDiagnosis(diagnosis);
	}
}
