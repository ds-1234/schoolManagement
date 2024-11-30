package com.project.school.management.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_marks")
public class StudentMarksEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "student_id")
	private Long studentId;

	@Column(name = "exam_marks")
	private Long examMarks;

	@Column(name = "remarks")
	private String remarks;

	@ManyToOne
	@JoinColumn(name = "exam_result_id", nullable = false)
	private ExamResultEntity examData;

}
