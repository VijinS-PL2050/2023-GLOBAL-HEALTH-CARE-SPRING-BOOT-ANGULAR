package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.DoctorDetails;

public interface IDoctorRepo extends CrudRepository<DoctorDetails, Integer> {
	
	@Query("FROM DoctorDetails WHERE isActive=true order by doctorId")
	public List<DoctorDetails> allDoctorDetailss();
	
	@Query("FROM DoctorDetails WHERE dId=?1 AND isActive=true order by doctorId")
	public List<DoctorDetails> getAllDoctorDetailss(Integer deptId);
	
	@Query("FROM DoctorDetails WHERE uId=?1 AND isActive=true")
	public DoctorDetails getDoctorByuId(Integer uId);

}
