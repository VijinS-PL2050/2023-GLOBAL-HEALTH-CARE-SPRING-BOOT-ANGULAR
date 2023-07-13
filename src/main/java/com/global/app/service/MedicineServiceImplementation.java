package com.global.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.entity.MedicinePrescription;
import com.global.app.repo.IMedicineRepo;

@Service
public class MedicineServiceImplementation implements IMedicineService{
	@Autowired
	private IMedicineRepo medicinerepo;
 
	@Override
	public void saveMedicine(MedicinePrescription medicine) {
		medicine.setMedicinePrescriptionDate(LocalDate.now());
		medicine=medicinerepo.save(medicine);
		medicine.setMedicinePrescriptionId("MI"+medicine.getMpId());
		System.out.println("kjhgfds");
		System.out.println(medicine.toString());
		medicinerepo.save(medicine);

	}

	@Override
	public List<MedicinePrescription> medicineByDiId(Integer diId) {
		// TODO Auto-generated method stub
		return medicinerepo.medicinePrescriptionByDiId(diId);
	}

	@Override
	public List<MedicinePrescription> getMedicinePrescriptionForPatient(Integer pId) {
		// TODO Auto-generated method stub
		return medicinerepo.getMedicinePrescriptionForPatient(pId);
	}

	@Override
	public void deleteMedicine(int mpId) {
		MedicinePrescription medicinePrescription=medicinerepo.findById(mpId).orElseThrow(() -> new RuntimeException("Prescription not found for " + mpId));
		
		medicinePrescription.setIsActive(false);
		//System.out.println(medicinePrescription.toString());
		medicinerepo.save(medicinePrescription);
	}
}
