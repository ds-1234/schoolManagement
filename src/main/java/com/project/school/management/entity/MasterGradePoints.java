package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "master_grade_points")
public class MasterGradePoints {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "grade_points_id", nullable = false)
	private String gradePointsId;
	
	@Column(name = "grade", nullable = false)
	private String grade;
	
	@Column(name = "percentage_from", nullable = false)
	private String percentageFrom;
	
	@Column(name = "percentage_upto", nullable = false)
	private String percentageUpto;
	
	@Column(name = "grade_points", nullable = false)
	private String gradePoints;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "isActive", nullable = false)
	private Boolean isActive;

}
