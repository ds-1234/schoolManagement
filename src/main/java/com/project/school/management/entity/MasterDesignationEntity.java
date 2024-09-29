package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "master_designation")
public class MasterDesignationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "designation_id", nullable = false)
	private String designationId;
	
	@Column(name = "designation_name", nullable = false)
	private String designationName;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;

}
