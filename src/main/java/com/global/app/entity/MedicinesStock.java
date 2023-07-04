package com.global.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class MedicinesStock {
	
	@Id
	@SequenceGenerator(name = "zMedSeq", sequenceName = "zMedSeq", initialValue = 70000, allocationSize = 1)
	@GeneratedValue(generator = "zMedSeq")
	private Integer msId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String medicineId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String medicineName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String companyName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private  String genericName;
	
	@NotNull(message = "is required")
	private Integer quantity;
	
	@NotNull(message = "is required")
	private Double price;
	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	@Getter(AccessLevel.NONE)
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "medicinesStock")
	private List<MedicinePrescription> medicinePrescription;

	
}
