package com.global.app.service;

import java.util.List;

import com.global.app.entity.Diagnosis;
import com.global.app.entity.MedicinePrescription;

public interface IMedicineService {

	//Insert
	public void saveMedicine(MedicinePrescription medicine);

	public List<MedicinePrescription> medicineByDiId(Integer diId);
	public List<MedicinePrescription> getMedicinePrescriptionForPatient(Integer pId);

	public void deleteMedicine(int mpId);
}
