package com.global.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.app.entity.Diagnosis;
import com.global.app.entity.MedicinePrescription;
import com.global.app.entity.TestReport;
import com.global.app.service.IAppointmentService;
import com.global.app.service.IDiagnosisService;
import com.global.app.service.IPatientService;
import com.global.app.service.IReportService;
import com.global.app.service.ITokenGeneratorService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class ReportController {
	@Autowired
	private IReportService reportservice;

	@Autowired
	private IDiagnosisService diagnosisservice;
	
	@Autowired
	private ITokenGeneratorService tokenGeneratorService;
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@Autowired
	private IPatientService patientService;
	
	@GetMapping("/getreports/{tpId}")
	public  TestReport getReport(@PathVariable Integer tpId) {
		System.out.println("i mmngf");
		return reportservice.getReport(tpId); // save for add and update
	

	}
	@GetMapping("/histTestReport/{tId}")
	public List<TestReport> histTestReport(@PathVariable Integer tId) {
		Integer aId=tokenGeneratorService.getToken(tId).getAId();
		Integer pId=appointmentService.getAppointment(aId).getPId();
		System.out.println("kjhgf   "+pId);
		return reportservice.getTestReportForPatient(pId);
	}
	
}
