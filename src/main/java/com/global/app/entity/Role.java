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

import lombok.Data;

@Entity
@Data
public class Role {

	// instance variable
	@Id
	@SequenceGenerator(name = "zRoleSeq", sequenceName = "zRoleSeq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "zRoleSeq")
	private Integer rId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String roleId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String roleName;
	
	@NotNull(message = "is required")
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isActive=true;
	
	@OneToMany(mappedBy = "role")
	private List<User> user;
}
