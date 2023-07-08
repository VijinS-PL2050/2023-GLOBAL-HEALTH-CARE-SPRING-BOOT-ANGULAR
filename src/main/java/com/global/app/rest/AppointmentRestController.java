package com.global.app.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.app.entity.Appointment;
import com.global.app.entity.BillAppoinment;
import com.global.app.entity.DoctorDetails;
import com.global.app.entity.TokenGenarator;
import com.global.app.service.IAppointmentService;
import com.global.app.service.IDoctorAndDepartmentService;
import com.global.app.service.IPatientService;
import com.global.app.service.ITokenGeneratorService;
import com.global.app.service.SMSService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Slf4j
public class AppointmentRestController {

	@Autowired
	private IAppointmentService appointmentService;

	@Autowired
	private IPatientService patientService;

	@Autowired
	private BillAppoinment billAppoinment;

	@Autowired
	private DoctorDetails doctorDetails;

	@Autowired
	private TokenGenarator tokenGenarator;

	@Autowired
	private IDoctorAndDepartmentService doctorAndDepartmentService;

	@Autowired
	private ITokenGeneratorService tokenGeneratorService;

	@Autowired
	private SMSService smsService;

	@PostMapping("/appointment")
	public void insertAppointment(@RequestBody Appointment appointment, HttpSession session) {
		appointment = appointmentService.insertUpdateAppointment(appointment);
		BillAppoinment billAppoinment = generateBillAppoint(appointment);
		appointment.setBillAppoinment(billAppoinment);
		appointmentService.insertUpdateAppointment(appointment);
		Integer tokNo = generateToken(appointment);
		session.setAttribute("token", tokNo);

		smsServiceGenerator(appointment, tokNo);
	}

	private void smsServiceGenerator(Appointment appointment, Integer tokNo) {
		String smsNumber = ("+91" + patientService.getPatientRecords(appointment.getPId()).getPatientPhone());
		String name=patientService.getPatientRecords(appointment.getPId()).getPatientName().toUpperCase();
		String mrNo=patientService.getPatientRecords(appointment.getPId()).getMrNo();
		String bookNo=appointment.getBookingNo();
		LocalDateTime dateTime=appointment.getAppointmentDateTime();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String aDate = dateTime.format(dateFormatter);
        String aTime = dateTime.format(timeFormatter);
		String smsMessage = "Hi "+name+", your appointment at GLOBAL HEALTH CARE on "
				+aDate+ ", "+aTime+" has been confirmed and your MRN is "+mrNo+" and Booking No "+bookNo+"."
				+ " Thank you.";
		System.out.println(smsNumber);
		System.out.println(smsMessage);
		smsService.sendSMS(smsNumber, smsMessage);

	}

	private BillAppoinment generateBillAppoint(Appointment appointment2) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime noww = LocalDateTime.parse(LocalDateTime.now().format(format), format);
		billAppoinment.setPId(appointment2.getPId());
		billAppoinment.setAId(appointment2.getAId());
		billAppoinment.setBillDate(noww);
		billAppoinment.setIsActive(true);
		LocalDate todayDate = LocalDate.now();
		LocalDate patVal = patientService.getPatientRecords(appointment2.getPId()).getValidityDate();
		int doId = appointment2.getDoId();
		double fee = doctorAndDepartmentService.getDoctorDetails(doId).getConsultationFee();
		if (patVal.isBefore(todayDate)) {
			billAppoinment.setBillAmount(150 + fee);
		} else {
			billAppoinment.setBillAmount(fee);
		}
		return billAppoinment;
	}

	private int generateToken(Appointment appointment) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime noww = LocalDateTime.parse(LocalDateTime.now().format(format), format);
		LocalDateTime todayAt6 = LocalDate.now().atTime(20, 0);
		LocalDateTime appointDate = appointment.getAppointmentDateTime();
		doctorDetails = doctorAndDepartmentService.getDoctorDetails(appointment.getDoId());
		int maxToken = doctorDetails.getNoOfToken();
		String doctorId = doctorDetails.getDoctorId();
		if (appointDate.isAfter(noww) && appointDate.isBefore(todayAt6)) {
			if (maxToken > 0) {
				tokenGenarator.setTId(null);
				tokenGenarator.setTokenTime(appointment.getAppointmentDateTime().plusMinutes(15));
				tokenGenarator.setTokenNo("T" + doctorId + "00" + (31 - maxToken));
				tokenGenarator.setAId(appointment.getAId());
				tokenGeneratorService.insertUpdateTokenGenarator(tokenGenarator);
				doctorDetails.setNoOfToken(maxToken - 1);
				doctorAndDepartmentService.updateForToken(doctorDetails);
				return tokenGenarator.getTId();
			}
		}
		return 0;

	}

	@PutMapping("/appointment")
	public void updateAppointment(@RequestBody Appointment appointment, HttpSession session) {
		appointmentService.insertUpdateAppointment(appointment);
		int tokNo = generateToken(appointment);
		session.setAttribute("token", tokNo);
	}

	@GetMapping("/appointment")
	public List<Appointment> listAppointment() {
		return appointmentService.allAppointments();

	}

	@GetMapping("/appointment/{aId}")
	public Appointment getAppointment(@PathVariable Integer pId) {
		return appointmentService.getAppointment(pId);

	}

	@DeleteMapping("/appointment/{aId}")
	public void deleteAppointment(@PathVariable Integer aId) {
		appointmentService.deleteAppointment(appointmentService.getAppointment(aId));
	}
}
