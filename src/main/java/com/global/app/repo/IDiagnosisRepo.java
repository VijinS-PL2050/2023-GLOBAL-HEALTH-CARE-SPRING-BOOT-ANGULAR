package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.global.app.entity.Diagnosis;
import com.global.app.entity.PatientRecords;

public interface IDiagnosisRepo extends CrudRepository<Diagnosis, Integer> {

	@Query("FROM Diagnosis WHERE pId=?1 AND isActive=true")
	public List<Diagnosis> getDiagnosis(Integer pId);

	@Query("FROM Diagnosis WHERE isActive=true")
	public List<Diagnosis> allDiagnosisHistory();

	@Query("FROM Diagnosis WHERE pId=?1 AND isActive=true")
	public List<Diagnosis> diagnosisHistoryByPId(Integer pId);

	@Query("FROM Diagnosis WHERE diId=?1 AND isActive=true ")
	public List<Diagnosis> getDiagnosisBydiId(Integer diId);

	@Query("FROM Diagnosis WHERE tokenGenarator.doctorDetails.user.uId=?1 AND isActive=true ")
	public List<Diagnosis> getDiagnosisByuId(Integer uId);
	
	@Query("SELECT MAX(diId) FROM Diagnosis WHERE tId=?1 AND isActive=true")
	public Integer getDidByTid(Integer tId);
	

}
