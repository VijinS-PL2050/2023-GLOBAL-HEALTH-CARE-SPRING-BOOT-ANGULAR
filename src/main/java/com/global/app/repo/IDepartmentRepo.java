package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.DoctorDepartment;

public interface IDepartmentRepo extends CrudRepository<DoctorDepartment, Integer> {

	@Query("FROM DoctorDepartment WHERE isActive=true order by departmentId")
	public List<DoctorDepartment> allDepartment();
}
