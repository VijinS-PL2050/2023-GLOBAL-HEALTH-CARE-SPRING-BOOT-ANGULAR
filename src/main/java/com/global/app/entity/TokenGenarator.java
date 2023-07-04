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

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Data
public class TokenGenarator {

	
	//instance variable
	@Id
	@SequenceGenerator(name = "zTokSeq", sequenceName = "zTokSeq", initialValue = 500, allocationSize = 1)
	@GeneratedValue(generator = "zTokSeq")
	private Integer tId;
	
	@Size(min = 1, max = 25)
	private String tokenNo;

	@NotNull(message = "is required")
	private LocalDateTime tokenTime;

	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	private Integer aId;
	@OneToOne
	@JoinColumn(name = "aId",insertable=false,updatable=false)
	private Appointment appointment;
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@OneToOne(mappedBy = "tokenGenarator")
	private Diagnosis diagnosis;


}
