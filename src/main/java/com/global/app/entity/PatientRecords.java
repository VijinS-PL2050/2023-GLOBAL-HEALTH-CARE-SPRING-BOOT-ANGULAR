package com.global.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class PatientRecords {
	
	
	@Id
	@SequenceGenerator(name = "zPatSeq", sequenceName = "zPatSeq", initialValue = 1001000, allocationSize = 1)
	@GeneratedValue(generator = "zPatSeq")
	private Integer pId;
	
	//@Size(min = 1, max = 25)
	@Column(unique=true)
	private String mrNo;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String patientName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String patientPhone;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String patientAddress;
	
	@NotNull(message = "is required")
	@Range(min=0, max=90)
	private int patientAge;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 10)
	private String patientGender;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String patientBlood;
	
	@NotNull(message = "is required")
	private LocalDate registrationDate;
	
	@NotNull(message = "is required")
	private LocalDate validityDate;
	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	@EqualsAndHashCode.Exclude
	@Getter(AccessLevel.NONE)
	@OneToMany(mappedBy = "patientRecords")
	private List<Appointment> appointment;
	
	@EqualsAndHashCode.Exclude
	@Getter(AccessLevel.NONE)
	@OneToMany(mappedBy = "patientRecords", cascade=CascadeType.ALL)
	private List<BillAppoinment> billAppoinment;

	
}
