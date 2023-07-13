package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.MedicinesStock;

public interface IMedicineForDiagnosis extends CrudRepository<MedicinesStock, Integer> {
	
	@Query("FROM MedicinesStock WHERE quantity>30 AND isActive=true")
	public List<MedicinesStock> getAllMedicineGreaterThan30Qty();

}
