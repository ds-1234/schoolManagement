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

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="exam_result")
public class ExamResultEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "teacher_id")
	private Long teacherId;
	
	@Column(name = "class_name")
	private Long className;
	
	@Column(name = "subject_id")
	private Long subjectId;
	
	@Column(name = "status")
	private Boolean isActive;
	
	@Column(name = "exam_type")
	private Long examType;
	

}
