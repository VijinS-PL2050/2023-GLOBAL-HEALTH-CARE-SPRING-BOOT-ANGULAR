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

import lombok.Data;

@Entity
@Data
public class Dosage {
	
	@Id
	@SequenceGenerator(name = "zDosSeq", sequenceName = "zDosSeq", initialValue = 70000, allocationSize = 1)
	@GeneratedValue(generator = "zDosSeq")
	private Integer dosId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String dosageId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String dosage;
	
	@NotNull(message = "is required")
	private Integer quantity;

	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;

	@OneToMany(mappedBy = "dosage")
	private List<MedicinePrescription> medicinePrescription;



}
