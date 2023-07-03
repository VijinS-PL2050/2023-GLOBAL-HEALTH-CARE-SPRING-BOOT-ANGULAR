package com.global.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//here appointmant id is foreignkey

@Entity
@Data
public class Diagnosis {
	
	
	@Id
	@SequenceGenerator(name = "zDiaSeq", sequenceName = "zDiaSeq", initialValue = 2000, allocationSize = 1)
	@GeneratedValue(generator = "zDiaSeq")
	private Integer diId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String diagnosisId;
	
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String findOut;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String notes;
	
	@NotNull(message = "is required")
	private LocalDate diagnosisDate;
	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	private Integer tId;
	@OneToOne
	@JoinColumn(name = "tId",insertable=false,updatable=false)
	private TokenGenarator tokenGenarator;
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "diagnosis")
	private List< MedicinePrescription> medicinePrescription;
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "diagnosis")
	private List< TestPrescription> TestPrescription;

	
}
