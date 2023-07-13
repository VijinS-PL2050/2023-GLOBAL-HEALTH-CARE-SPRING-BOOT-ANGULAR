package com.global.app.rest;

import java.time.LocalDate;
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
import com.global.app.service.IAppointmentService;
import com.global.app.service.IDiagnosisService;
import com.global.app.service.IMedicineService;
import com.global.app.service.IPatientService;
import com.global.app.service.ITokenGeneratorService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class MedicinePrescriptionController {
	@Autowired
	private IMedicineService medicineservice;

	@Autowired
	private IDiagnosisService diagnosisservice;

	@Autowired
	private ITokenGeneratorService tokenGeneratorService;

	@Autowired
	private IAppointmentService appointmentService;

	@Autowired
	private IPatientService patientService;

	@PostMapping("/medicine")
	public void addMedicine(@RequestBody MedicinePrescription medicine) {
		System.out.println("medicine");
		System.out.println(medicine.toString());

		medicineservice.saveMedicine(medicine); // save for add and update

	}

	@GetMapping("/medicine/{diId}")
	public List<MedicinePrescription> medicineByDiId(@PathVariable Integer diId) {

		return medicineservice.medicineByDiId(diId);
	}

	// delete medicine
	@DeleteMapping("/deletemedicine/{mpId}")
	public void deleteMedicine(@PathVariable int mpId) {
		medicineservice.deleteMedicine(mpId);
	}

	@GetMapping("/histMedicine/{tId}")
	public List<MedicinePrescription> histMedicineForPatient(@PathVariable Integer tId) {
		Integer aId = tokenGeneratorService.getToken(tId).getAId();
		Integer pId = appointmentService.getAppointment(aId).getPId();
		System.out.println("kjhgf   " + pId);
		return medicineservice.getMedicinePrescriptionForPatient(pId);
	}
}
