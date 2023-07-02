package com.global.app.entity;

import java.time.LocalDateTime;

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

import lombok.Data;

@Entity
@Data
public class BillAppoinment {
	
	@Id
	@SequenceGenerator(name = "zBillAppSeq", sequenceName = "zBillAppSeq", initialValue = 700800, allocationSize = 1)
	@GeneratedValue(generator = "zBillAppSeq")
	private Integer baId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String billAppoinmentNo;
	
	@NotNull(message = "is required")
	private LocalDateTime billDate;
	
	@NotNull(message = "is required")
	private Double billAmount;
	
	@NotNull(message = "is required")
	private Boolean isActive=true;

	private Integer aId;
	@OneToOne
	@JoinColumn(name = "aId",insertable=false,updatable=false)
	private Appointment appointment;
	
	private Integer pId;
	@ManyToOne
	@JoinColumn(name = "pId",insertable=false,updatable=false)
	private PatientRecords patientRecords;

	

}
