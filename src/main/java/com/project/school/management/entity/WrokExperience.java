package com.project.school.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "WrokExperience")
public class WrokExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String teacherId;

	private String fromYear;
	
	private String toYear;
	
	private String insitutue;
	
	private String designation;
	
}
