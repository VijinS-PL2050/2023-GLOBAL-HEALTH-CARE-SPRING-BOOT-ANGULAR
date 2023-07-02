package com.global.app.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Appointment {

	
	@Id
	@SequenceGenerator(name = "zAppSeq", sequenceName = "zAppSeq", initialValue = 5000, allocationSize = 1)
	@GeneratedValue(generator = "zAppSeq")
	private Integer aId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String bookingNo;

	@NotNull(message = "is required")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime appointmentDateTime;
	
	@NotNull(message = "is required")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime appointmentValidity;
	
	@NotNull(message = "is required")
	private Boolean isActive=true;
	
	private Integer dId;
	@ManyToOne
	@JoinColumn(name = "dId",insertable=false,updatable=false)
	private DoctorDepartment doctorDepartment;
	
	private Integer doId;
	@ManyToOne
	@JoinColumn(name = "doId",insertable=false,updatable=false)
	private DoctorDetails doctorDetails;
	
	private Integer pId;
	@ManyToOne
	@JoinColumn(name = "pId",insertable=false,updatable=false)
	private PatientRecords patientRecords;
	
	
	@OneToOne(mappedBy = "appointment")
	private TokenGenarator tokenGenarator;
	
	@OneToOne(mappedBy = "appointment", cascade=CascadeType.ALL)
	private BillAppoinment billAppoinment;

}
