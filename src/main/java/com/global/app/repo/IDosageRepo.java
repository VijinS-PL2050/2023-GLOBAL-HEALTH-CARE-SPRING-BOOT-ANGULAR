package com.global.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.Dosage;

public interface IDosageRepo extends CrudRepository<Dosage, Integer> {

}
