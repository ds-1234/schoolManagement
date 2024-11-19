package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "classSubject")
public class ClassSubjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "teacherId")
	private String teacherId;

	@Column(name = "classId")
	private String classId;

	@Column(name = "subjectId")
	private String subjectId;
	
	@Column(name = "isActive")
	private String isActive;

}
