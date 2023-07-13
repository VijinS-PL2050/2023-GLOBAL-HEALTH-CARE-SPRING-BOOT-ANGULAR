package com.global.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.app.entity.Diagnosis;
import com.global.app.entity.MedicinePrescription;
import com.global.app.entity.TestPrescription;
import com.global.app.service.IAppointmentService;
import com.global.app.service.IDiagnosisService;
import com.global.app.service.IPatientService;
import com.global.app.service.ITestService;
import com.global.app.service.ITokenGeneratorService;
import com.global.app.service.ITokenService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class TestPrescriptionController {
	@Autowired
	private ITestService testservice;
	
	@Autowired
	private IDiagnosisService diagnosisservice;
	
	@Autowired
	private ITokenGeneratorService tokenGeneratorService;
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@Autowired
	private IPatientService patientService;
	
	@PostMapping("/test")
	public void addTest(@RequestBody TestPrescription testprescription) {
		testservice.saveTest(testprescription); // save for add and update

	}
	@GetMapping("/test/{diId}")
	public List<TestPrescription> testByDiId(@PathVariable Integer diId) {
	
		return testservice.testByDiId(diId);
	}
	@GetMapping("/histTest/{tId}")
	public List<TestPrescription> histTestForPatient(@PathVariable Integer tId) {
		Integer aId=tokenGeneratorService.getToken(tId).getAId();
		Integer pId=appointmentService.getAppointment(aId).getPId();
		System.out.println("gghgf "+pId);
		return testservice.getTestPrescriptionForPatient(pId);
	}
	@DeleteMapping("/deletetest/{tpId}")
	public void deleteTest(@PathVariable int tpId) {
		testservice.deletetest(tpId);
	}
	
	
}
