package com.global.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class StaffDeatils {
	
	
	@Id
	@SequenceGenerator(name = "zStaffSeq", sequenceName = "zStaffSeq", initialValue = 90000, allocationSize = 1)
	@GeneratedValue(generator = "zStaffSeq")
	private Integer sId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String staffid;
	
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String staffname;
	
	@NotNull(message = "is required")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	
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
	@Column(unique=true)
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
	@Size(min = 1, max = 25)
	private Boolean IsActive=true;
	
	private Integer uId;
	@OneToOne
	@JoinColumn(name = "uId",insertable=false,updatable=false)
	private User user;

	
}
