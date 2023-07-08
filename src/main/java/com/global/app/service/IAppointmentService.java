package com.global.app.service;

import java.util.List;

import com.global.app.entity.Appointment;

public interface IAppointmentService {

	public Appointment insertUpdateAppointment(Appointment appointment);
	public List<Appointment> allAppointments();
	public void deleteAppointment(Appointment appointment);
	public Appointment getAppointment(Integer aId);
}
