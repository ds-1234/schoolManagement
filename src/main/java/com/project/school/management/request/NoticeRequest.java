package com.project.school.management.request;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeRequest {

	Long id;
	String noticeTitle;
	String noticeDetails;
	Long userId;
	Date noticeDate;
	Long role;
	Boolean isActive;

}
