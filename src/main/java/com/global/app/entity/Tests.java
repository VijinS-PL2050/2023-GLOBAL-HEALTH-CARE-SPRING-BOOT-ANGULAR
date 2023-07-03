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
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Tests {
	
	@Id
	@SequenceGenerator(name = "zTestSeq", sequenceName = "zTestSeq", initialValue = 89000, allocationSize = 1)
	@GeneratedValue(generator = "zTestSeq")
	private Integer ttId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String testId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String testName;
	
	@NotNull(message = "is required")
	private Double highValue;
	
	@NotNull(message = "is required")
	private Double lowValue;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String unit;
	
	@NotNull(message = "is required")
	private Integer testPrice;
	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "tests")
	private List<TestPrescription> testPrescription;

}
