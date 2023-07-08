package com.global.app.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import com.global.app.entity.BillAppoinment;
import com.global.app.entity.PatientRecords;
import com.global.app.service.IPatientService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Slf4j
public class PatientsRestController {

	@Autowired
	private IPatientService patientService;
	
	@Autowired
	private BillAppoinment billAppoinment;
	
	@PostMapping("/patients")
	public void insertPatientRecord(@RequestBody PatientRecords patientRecords  ) {
		patientRecords=patientService.insertUpdatePatientRecords(patientRecords);
		List<BillAppoinment> multiBill=genarateBillRegister(patientRecords);
		patientRecords.setBillAppoinment(multiBill);
		patientService.insertUpdatePatientRecords(patientRecords);
	}
	
	private List<BillAppoinment> genarateBillRegister(PatientRecords forPatientRecords2) {
		List<BillAppoinment> multiBill= new ArrayList<BillAppoinment>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime noww = LocalDateTime.parse(LocalDateTime.now().format(format), format);
		//billAppoinment.setPatientRecords(forPatientRecords2);
		billAppoinment.setPId(forPatientRecords2.getPId());
		billAppoinment.setBillAmount(150.00);
		billAppoinment.setBillDate(noww);
		billAppoinment.setIsActive(true);
		multiBill.add(billAppoinment);		
		return multiBill;
		
	}
	
	@PutMapping("/patients")
	public void updatePatientRecord(@RequestBody PatientRecords patientRecords  ) {
		patientService.insertUpdatePatientRecords(patientRecords);
	}
	
	@GetMapping("/patients")
	public List<PatientRecords>listPatientRecords(){
		return patientService.allPatientRecords();
		
	}
	
	@GetMapping("/patients/{pId}")
	public PatientRecords getPatientRecords(@PathVariable Integer pId) {
		return patientService.getPatientRecords(pId);
		
	}
	
	@DeleteMapping("/patients/{pId}")
	public void deletePatientRecords(@PathVariable Integer pId) {
		patientService.deletePatientRecords(patientService.getPatientRecords(pId));
	}
	
}
