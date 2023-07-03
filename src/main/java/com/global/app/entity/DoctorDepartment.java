package com.global.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class DoctorDepartment {

	@Id
	@SequenceGenerator(name = "zDepSeq", sequenceName = "zDepSeq", initialValue = 200, allocationSize = 1)
	@GeneratedValue(generator = "zDepSeq")
	private Integer dId;

	@Size(min = 1, max = 25)
	@Column(unique = true)
	private String departmentId;

	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique = true)
	private String departmentName;

	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive = true;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "doctorDepartment", fetch = FetchType.EAGER)
	private List<DoctorDetails> doctorDetails;

	

}
