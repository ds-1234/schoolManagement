package com.project.school.management.entity;

import java.sql.Date;

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
@Table(name ="notice")
public class NoticeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "notice_title", nullable = false)
	private String noticeTitle;
	
	@Column(name = "notice_details", nullable = false)
	private String noticeDetails;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "notice_date", nullable = false)
	private Date noticeDate;
	
	@Column(name = "notice_id", nullable = false)
	private String noticeId;
	
	@Column(name = "role", nullable = false)
	private Long role;
	
	@Column(name = "status")
	private Boolean isActive;

}
