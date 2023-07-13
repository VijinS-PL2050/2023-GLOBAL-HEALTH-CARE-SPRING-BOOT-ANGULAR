package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.TestPrescription;

public interface ITestPresRepo extends  CrudRepository<TestPrescription,Integer>{
	@Query("FROM TestPrescription WHERE diId=?1 AND isActive=true")
	public List<TestPrescription> testByDiId(Integer diId);
	
	@Query("FROM TestPrescription WHERE diagnosis.patientRecords.pId=?1 AND isActive=true")
	public List<TestPrescription> getTestPrescriptionForPatient(Integer pId);

}
