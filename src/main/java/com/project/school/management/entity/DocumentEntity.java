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
@Table(name = "document")
public class DocumentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "userId")
	private String userId;
	
	@Column(name = "attachment_name")
	private String attachmentName;
	
	@Column(name = "attachment_path")
	private String attachmentPath;
	
	@Column(name = "document_name")
	private String documentName;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;
}
