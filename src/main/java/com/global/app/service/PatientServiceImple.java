package com.global.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.entity.PatientRecords;
import com.global.app.repo.IPatientsRepo;

@Service
public class PatientServiceImple implements IPatientService {

	private IPatientsRepo repo;

	@Autowired
	public PatientServiceImple(IPatientsRepo repo) {
		this.repo = repo;
	}

	@Override
	public PatientRecords insertUpdatePatientRecords(PatientRecords patientRecords) {
		if (patientRecords.getRegistrationDate() == null) {
			patientRecords.setRegistrationDate(LocalDate.now());
			patientRecords.setValidityDate(patientRecords.getRegistrationDate().plusMonths(6));
		}
		repo.save(patientRecords);
		patientRecords.setMrNo("GL" + patientRecords.getPId());
		return repo.save(patientRecords);

	}

	@Override
	public List<PatientRecords> allPatientRecords() {

		return repo.allPatientRecords();
	}

	@Override
	public void deletePatientRecords(PatientRecords patientRecords) {
		patientRecords.setIsActive(false);
		repo.save(patientRecords);

	}

	@Override
	public PatientRecords getPatientRecords(Integer pId) {

		return repo.findById(pId).orElseThrow(() -> new RuntimeException("Patient not found for " + pId));
	}

}
