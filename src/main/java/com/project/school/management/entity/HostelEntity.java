package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "hostel")
public class HostelEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "hostel_id", nullable = false)
	private String hostelId;
	
	@Column(name = "hostel_name", nullable = false)
	private String hostelName;
	
	//hotstelType = boys/girls
	@Column(name = "hostel_type", nullable = false)
	private String hostelType;
	
	@Column(name = "intake_bed_count", nullable = false)
	private Long intakeBedCount;
	
	@Column(name = "hostel_address", nullable = false)
	private String hostelAddress;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;
	
	

}
