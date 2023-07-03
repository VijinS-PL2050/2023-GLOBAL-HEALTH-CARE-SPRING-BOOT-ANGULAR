package com.global.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class User {

	//instance varaible
	@Id
	@SequenceGenerator(name = "zUserSeq", sequenceName = "zUserSeq", initialValue = 90000, allocationSize = 1)
	@GeneratedValue(generator = "zUserSeq")
	private Integer uId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String userId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String userName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String password;
	

	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	private Integer rId;
	@ManyToOne
	@JoinColumn(name = "rId",insertable=false,updatable=false)
	private Role role;
	
	
	@OneToOne(mappedBy = "user")
	private DoctorDetails doctorDetails;
	
	
	@OneToOne(mappedBy = "user")
	private StaffDeatils staffDeatils;


		
}
