package com.global.app.entity;

import java.time.LocalDateTime;

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

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Component
@Data
public class BillAppoinment {
	
	@Id
	@SequenceGenerator(name = "zBillAppSeq", sequenceName = "zBillAppSeq", initialValue = 700800, allocationSize = 1)
	@GeneratedValue(generator = "zBillAppSeq")
	private Integer baId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String billAppoinmentNo;
	
	@NotNull(message = "is required")
	private LocalDateTime billDate;
	
	@NotNull(message = "is required")
	private Double billAmount;
	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;

	private Integer aId;
	@OneToOne
	@Getter(AccessLevel.NONE)
	@JoinColumn(name = "aId",insertable=false,updatable=false)
	private Appointment appointment;
	
	private Integer pId;
	@ManyToOne
	@Getter(AccessLevel.NONE)
	@JoinColumn(name = "pId",insertable=false,updatable=false)
	private PatientRecords patientRecords;

	

}
