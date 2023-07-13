package com.global.app.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.entity.MedicinePrescription;
import com.global.app.entity.TestPrescription;
import com.global.app.repo.ITestPresRepo;

@Service
public class TestServiceImplementation implements ITestService{
	@Autowired
	private ITestPresRepo testrepo;

	@Override
	public void saveTest(TestPrescription testprescription) {
		testprescription.setTestDay(LocalDate.now());
		testprescription=testrepo.save(testprescription);
		testprescription.setTestPrescriptionId("PI"+testprescription.getTpId());;
		testrepo.save(testprescription);
		
	}

	@Override
	public List<TestPrescription> testByDiId(Integer diId) {
		// TODO Auto-generated method stub
		return testrepo.testByDiId(diId);
	}

	@Override
	public List<TestPrescription> getTestPrescriptionForPatient(Integer pId) {
		// TODO Auto-generated method stub
		return testrepo.getTestPrescriptionForPatient(pId);
	}

	@Override
	public void deletetest(int tpId) {
		TestPrescription testprescription=testrepo.findById(tpId).orElseThrow(() -> new RuntimeException("Test Prescription not found for " + tpId));
		testprescription.setIsActive(false);
		testrepo.save(testprescription);
	}
	


	

}
