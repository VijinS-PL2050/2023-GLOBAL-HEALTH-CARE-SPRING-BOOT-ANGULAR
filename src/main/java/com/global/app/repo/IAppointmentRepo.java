package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.Appointment;

public interface IAppointmentRepo extends CrudRepository<Appointment, Integer> {
	
	@Query("FROM Appointment WHERE isActive=true order by bookingNo")
	public List<Appointment> allAppointments();

}
