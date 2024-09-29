package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "master_department")
public class MasterDepartmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "department_id", nullable = false)
	private String departmentId;
	
	@Column(name = "department_name", nullable = false)
	private String departmentName;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;

}
