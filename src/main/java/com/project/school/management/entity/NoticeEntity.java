package com.project.school.management.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "posted_by", nullable = false)
	private String postedBy;
	
	@Column(name = "notice_date", nullable = false)
	private Date noticeDate;
	
	@Column(name = "notice_id", nullable = false)
	private String noticeId;

}
