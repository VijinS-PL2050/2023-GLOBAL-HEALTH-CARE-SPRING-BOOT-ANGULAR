package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.MedicinePrescription;
import com.global.app.entity.TestPrescription;
import com.global.app.entity.TestReport;

public interface IReportRepo extends  CrudRepository<TestReport,Integer> {
	@Query("FROM TestReport t WHERE t.rpId=(SELECT MAX (t2.rpId)FROM TestReport t2 WHERE tpId=?1 AND isActive=true)")
	public TestReport getreport(Integer tpId);
	
	@Query("FROM TestReport WHERE testPrescription.diagnosis.patientRecords.pId=?1 AND isActive=true")
	public List<TestReport> getTestReportForPatient(Integer pId);

}
