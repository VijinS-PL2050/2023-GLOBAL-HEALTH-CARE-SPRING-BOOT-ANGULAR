package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.MedicinesStock;
import com.global.app.entity.Tests;

public interface ITestForDiagnosis extends CrudRepository<Tests,Integer> {

	@Query("FROM Tests WHERE isActive=true")
	public List<Tests> getAllTests();

}
