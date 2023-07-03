package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.PatientRecords;

public interface IPatientsRepo extends CrudRepository<PatientRecords, Integer> {
	
	@Query("FROM PatientRecords WHERE isActive=true order by mrNo")
	public List<PatientRecords> allPatientRecords();
	
	

}
