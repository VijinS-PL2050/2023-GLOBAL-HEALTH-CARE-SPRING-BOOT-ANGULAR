package com.global.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class TestReport {
	
	@Id
	@SequenceGenerator(name = "zTestRepSeq", sequenceName = "zTestRepSeq", initialValue = 3001000, allocationSize = 1)
	@GeneratedValue(generator = "zTestRepSeq")
	private Integer rpId;
	
	@Column(unique=true)
	private Integer reportId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String Report;
	
	@NotNull(message = "is required")
	private LocalDate reportDate;
		
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String actualValue;
	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@OneToOne(mappedBy="testReport")
	private TestPrescription testPrescription;

	
}
