package com.project.school.management.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name ="library")
public class LibraryEntity {
	@Id
	private Long id;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "issue_id")
	private String issueId;

	@Column(name = "issued_date")
	private Date issuedDate;
	
	@Column(name = "return_date")
	private Date returnDate;
	
	@Column(name = "book_number")
	private String bookNumber;
	
	@Column(name = "status")
	private Boolean isActive;
	
	@Column(name = "book_mapping")
	private Long bookMapping;
}
