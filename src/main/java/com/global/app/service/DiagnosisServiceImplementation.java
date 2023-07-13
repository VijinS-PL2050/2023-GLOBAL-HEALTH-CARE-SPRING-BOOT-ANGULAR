package com.global.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.entity.Diagnosis;
import com.global.app.entity.Dosage;
import com.global.app.entity.MedicinesStock;
import com.global.app.entity.TestPrescription;
import com.global.app.entity.Tests;
import com.global.app.repo.IDiagnosisRepo;
import com.global.app.repo.IDosageRepo;
import com.global.app.repo.IMedicineForDiagnosis;
import com.global.app.repo.ITestForDiagnosis;

@Service
public class DiagnosisServiceImplementation implements IDiagnosisService {
	@Autowired
	private IDiagnosisRepo diagnosisrepo;
	
	@Autowired
	private IDosageRepo dosageRepo;
	
	@Autowired
	private IMedicineForDiagnosis medicineForDiagnosis;
	
	@Autowired
	private ITestForDiagnosis testForService;

	@Override
	public void saveDiagnosis(Diagnosis diagnosis) {
		diagnosis.setDiagnosisDate(LocalDate.now());
		System.out.println(diagnosis.toString());
		diagnosis=diagnosisrepo.save(diagnosis);
		diagnosis.setDiagnosisId("DI"+diagnosis.getDiId());
		System.out.println("save diago");
		System.out.println(diagnosis.toString());
		diagnosisrepo.save(diagnosis);
	}

	@Override
	public List<Diagnosis> getDiagnosis(Integer pId) {
		// TODO Auto-generated method stub
		return diagnosisrepo.getDiagnosis(pId);
	}

	@Override
	public List<Diagnosis> allDiagnosisHistory() {
		// TODO Auto-generated method stub
		return diagnosisrepo.allDiagnosisHistory();
	}

	@Override
	public List<Diagnosis> diagnosisHistoryByPId(Integer pId) {
		System.out.println(diagnosisrepo.diagnosisHistoryByPId(pId).indexOf(0));
		return diagnosisrepo.diagnosisHistoryByPId(pId);
	}
	@Override
	public void saveSymptoms(Diagnosis diagnosis) {
		diagnosisrepo.save(diagnosis);
		diagnosis.setDiagnosisId("DI"+diagnosis.getDiId());
		diagnosisrepo.save(diagnosis);
	}


	@Override
	public List<Diagnosis> getDiagnosisBydiId(Integer diId) {
		// TODO Auto-generated method stub
		return diagnosisrepo.getDiagnosisBydiId(diId);
	}
	


	@Override
	public List<Diagnosis> getDiagnosisByuId(Integer uId) {
		// TODO Auto-generated method stub
		return diagnosisrepo.getDiagnosisByuId(uId);
	}

	@Override
	public void saveDoctornote(Diagnosis diagnosis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dosage> allDosages() {
		// TODO Auto-generated method stub
		return (List<Dosage>) dosageRepo.findAll();
	}

	@Override
	public List<MedicinesStock> allMedicine() {
		return medicineForDiagnosis.getAllMedicineGreaterThan30Qty();
	}

	@Override
	public Integer getDidByTid(Integer tId) {
		// TODO Auto-generated method stub
		return diagnosisrepo.getDidByTid(tId);
	}

	@Override
	public List<Tests> AllTest() {
		// TODO Auto-generated method stub
		return testForService.getAllTests();
	}


}
