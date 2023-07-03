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
public class BillTest {

	@Id
	@SequenceGenerator(name = "zBillTestSeq", sequenceName = "zBillTestSeq", initialValue = 900800, allocationSize = 1)
	@GeneratedValue(generator = "zBillTestSeq")
	private Integer btId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String billTestNo;
	
	@NotNull(message = "is required")
	private LocalDateTime billDate;
	
	@NotNull(message = "is required")
	private Double billAmount;
	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	private Integer tpId;
	@OneToOne
	@JoinColumn(name = "tpId",insertable=false,updatable=false)
	private TestPrescription testPrescription;

}
