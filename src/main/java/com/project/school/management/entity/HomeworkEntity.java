package com.project.school.management.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "homework")
public class HomeworkEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "homework_id", nullable = false)
	private String homeworkId;
	
	@Column(name = "user", nullable = false)
	private Long user;
	
	@Column(name = "className", nullable = false)
	private Long className;
	
	@Column(name = "subject", nullable = false)
	private Long subject;
	
	@Column(name = "homework_date", nullable = false)
	private Date homeworkDate;
	
	@Column(name = "submission_date", nullable = false)
	private Date submissionDate;

	@Column(name = "attachment_name")
	private String attachmentName;
	
	@Column(name = "attachment_path")
	private String attachmentPath;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;
}
