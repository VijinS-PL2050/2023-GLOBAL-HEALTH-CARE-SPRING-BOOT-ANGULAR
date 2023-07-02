package com.global.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity	
@Data
public class BillMedicine {
	
	@Id
	@SequenceGenerator(name = "zBillMedSeq", sequenceName = "zBillMedSeq", initialValue = 900800, allocationSize = 1)
	@GeneratedValue(generator = "zBillMedSeq")
	private Integer bmId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String billMedicineNo;
	
	@NotNull(message = "is required")
	private LocalDateTime billDate;
	
	@NotNull(message = "is required")
	private Double billAmount;
	
	@NotNull(message = "is required")
	private Boolean isActive=true;
	
	private Integer mpId;
	@OneToOne
	@JoinColumn(name = "mpId",insertable=false,updatable=false)
	private MedicinePrescription medicinePrescription;

	
}

