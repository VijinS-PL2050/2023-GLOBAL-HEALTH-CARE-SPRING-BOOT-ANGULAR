package com.global.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.entity.Appointment;
import com.global.app.repo.IAppointmentRepo;

@Service
public class AppointmentServiceImple implements IAppointmentService {

	private IAppointmentRepo repo;
	@Autowired
	public AppointmentServiceImple(IAppointmentRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public Appointment insertUpdateAppointment(Appointment appointment) {
		appointment.setAppointmentValidity(appointment.getAppointmentDateTime().plusDays(7));
		repo.save(appointment);
		appointment.setBookingNo("AP"+appointment.getAId());
		return repo.save(appointment);

	}

	@Override
	public List<Appointment> allAppointments() {
		return repo.allAppointments();
	}

	@Override
	public void deleteAppointment(Appointment appointment) {
		appointment.setIsActive(false);
		repo.save(appointment);

	}

	@Override
	public Appointment getAppointment(Integer aId) {
		
		return  repo.findById(aId).orElseThrow(() -> new RuntimeException("Appointmnet not found for " + aId));
	}

}
