package com.global.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Data
public class DoctorDetails {

	@Id
	@SequenceGenerator(name = "zDocSeq", sequenceName = "zDocSeq", initialValue = 500, allocationSize = 1)
	@GeneratedValue(generator = "zDocSeq")
	private Integer doId;

	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String doctorId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)	
	private String doctorName;
	
	@NotNull(message = "is required")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateOfBirth;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String gender;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String bloodGroup;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String phoneno;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String address;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String adharNo;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String qualification;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String email;
	
	
	@NotNull(message = "is required")
	private Double consultationFee;

	@NotNull(message = "is required")
	private Integer noOfToken;

	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean IsActive=true;
	
	private Integer dId;
	@ManyToOne
	@JoinColumn(name = "dId",insertable=false,updatable=false)
	private DoctorDepartment doctorDepartment;
	
	private Integer uId;
	@OneToOne
	@JoinColumn(name = "uId",insertable=false,updatable=false)
	private User user;
	
	@Getter(AccessLevel.NONE)
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "doctorDetails",fetch = FetchType.EAGER)
	private List<Appointment> appointment;


}
