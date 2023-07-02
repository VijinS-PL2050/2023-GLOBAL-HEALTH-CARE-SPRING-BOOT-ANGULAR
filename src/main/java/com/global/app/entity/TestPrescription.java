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
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class TestPrescription {
	
	@Id
	@SequenceGenerator(name = "zTestPreSeq", sequenceName = "zTestPreSeq", initialValue = 201000, allocationSize = 1)
	@GeneratedValue(generator = "zTestPreSeq")
	private Integer tpId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String testPrescriptionId;
	
	private LocalDate testDay;
	
	private Boolean isActive;
	
	private Integer ttId;
	@ManyToOne
	@JoinColumn(name = "ttId",insertable=false,updatable=false)
	private Tests tests;
	
	private Integer diId;
	@ManyToOne
	@JoinColumn(name = "diId",insertable=false,updatable=false)
	private Diagnosis diagnosis;
	
	private Integer trId;
	@OneToOne
	@JoinColumn(name = "trId",insertable=false,updatable=false)
	private TestReport testReport;
	
	

	
	
	

}
