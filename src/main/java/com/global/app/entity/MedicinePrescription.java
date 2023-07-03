package com.global.app.entity;

import java.time.LocalDate;

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

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Data
public class MedicinePrescription {
	
	@Id
	@SequenceGenerator(name = "zMedPreSeq", sequenceName = "zMedPreSeq", initialValue = 300, allocationSize = 1)
	@GeneratedValue(generator = "zMedPreSeq")
	private Integer mpId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String medicinePrescriptionId;
	
	@NotNull(message = "is required")
	private Integer noOfDay;
	
	@NotNull(message = "is required")
	private LocalDate medicinePrescriptionDate;
	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	private Integer diId;
	@ManyToOne
	@JoinColumn(name = "diId",insertable=false,updatable=false)
	private Diagnosis  diagnosis;
	
	private Integer dosId;
	@ManyToOne
	@JoinColumn(name = "dosId",insertable=false,updatable=false)
	private Dosage dosage;
	
	private Integer msId;
	@ManyToOne
	@JoinColumn(name = "msId",insertable=false,updatable=false)
	private MedicinesStock medicinesStock;
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@OneToOne(mappedBy = "medicinePrescription")
	private BillMedicine BillMedicine;


		
}
