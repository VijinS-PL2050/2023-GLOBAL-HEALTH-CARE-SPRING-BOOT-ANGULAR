package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.Diagnosis;
import com.global.app.entity.MedicinePrescription;

public interface IMedicineRepo extends  CrudRepository<MedicinePrescription,Integer>{

	@Query("FROM MedicinePrescription WHERE diId=?1 AND isActive=true")
	public List<MedicinePrescription> medicinePrescriptionByDiId(Integer diId);
	
	@Query("FROM MedicinePrescription WHERE diagnosis.patientRecords.pId=?1 AND isActive=true")
	public List<MedicinePrescription> getMedicinePrescriptionForPatient(Integer pId);
}
