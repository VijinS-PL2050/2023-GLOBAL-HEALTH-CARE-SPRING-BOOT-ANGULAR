package com.global.app.service;

import java.util.List;

import com.global.app.entity.MedicinePrescription;
import com.global.app.entity.TestPrescription;

public interface ITestService {

	//Insert
			public void saveTest(TestPrescription testprescription);

			public List<TestPrescription> testByDiId(Integer diId);
			public List<TestPrescription> getTestPrescriptionForPatient(Integer pId);

			public void deletetest(int tpId);

}
