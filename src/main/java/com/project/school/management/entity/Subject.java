package com.project.school.management.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "subject", nullable = false)
	private String subject;

	@Column(name = "description", nullable = false)
	private String description;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToMany(fetch = FetchType.LAZY)
	List<ClassEntity> classEntity = new ArrayList<>();
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToMany(fetch = FetchType.LAZY)
	List<TimeTableEntity> timeTableEntity = new ArrayList<>();

}
