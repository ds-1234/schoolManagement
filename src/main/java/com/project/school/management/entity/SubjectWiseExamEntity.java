package com.project.school.management.entity;

import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "subjectwise_exam_entity")
public class SubjectWiseExamEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "exam_date")
	private Date examDate;

	@Column(name = "subject")
	private Long subject;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "duration")
	private String duration;

	@Column(name = "max_marks")
	private String maxMarks;

	@Column(name = "min_marks")
	private String minMarks;

}
