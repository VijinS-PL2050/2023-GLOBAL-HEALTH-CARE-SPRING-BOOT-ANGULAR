package com.global.app.service;

import java.util.List;

import com.global.app.entity.PatientRecords;


public interface IPatientService {
	
	public PatientRecords insertUpdatePatientRecords(PatientRecords patientRecords);
	public List<PatientRecords> allPatientRecords();
	public void deletePatientRecords(PatientRecords patientRecords);
	public PatientRecords getPatientRecords(Integer pId);

}
