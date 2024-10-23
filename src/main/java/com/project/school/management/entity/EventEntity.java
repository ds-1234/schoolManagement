package com.project.school.management.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name ="events")
public class EventEntity {
	
	@Id
	private Long id;
	
	@Column(name = "event_title")
	private String eventTitle;
	
	@Column(name = "event_for")
	private List<Long> role;
	
	@Column(name = "user_id")
	private List<Long> user;
	
	@Column(name = "class")
	private List<Long> className;
	
	@Column(name = "event_category")
	private Long eventCategory;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "message", length=2000)
	private String message;
	
//	@Column(name = "attachment_name")
//	private String attachmentName;
//	
//	@Column(name = "attachment_path")
//	private String attachmentPath;
	
	@Column(name = "status")
	private Boolean isActive;

}
