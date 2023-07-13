package com.global.app.service;

import java.util.List;

import com.global.app.entity.Diagnosis;
import com.global.app.entity.Dosage;
import com.global.app.entity.MedicinesStock;
import com.global.app.entity.TestPrescription;
import com.global.app.entity.Tests;

public interface IDiagnosisService {

		//Insert
		public void saveDiagnosis(Diagnosis diagnosis);

		public List<Diagnosis> getDiagnosis(Integer pId);

		public void saveDoctornote(Diagnosis diagnosis);
		
		public List<Diagnosis> allDiagnosisHistory();

		 public List<Diagnosis> diagnosisHistoryByPId(Integer pId);
		
		public void saveSymptoms(Diagnosis diagnosis);

		public List<Diagnosis> getDiagnosisBydiId(Integer diId) ;

		public List<Diagnosis> getDiagnosisByuId(Integer uId);
		
		
		//list all dosage
		public List<Dosage> allDosages();
		
		//list all medicine
		public List<MedicinesStock> allMedicine();
		
		//get did by tid
		public Integer getDidByTid(Integer tId);

		//list all test
		public List<Tests> AllTest();


		
		
	
}
