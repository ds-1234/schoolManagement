package com.project.school.management.request;

import java.sql.Date;

import lombok.Data;

@Data
public class EventRequest {

	Long id;

	String eventTitle;

	Long role;

	Long eventCategory;

	Date startDate;

	Date endDate;

	String startTime;

	String endTime;

	String message;

	Boolean isActive;

}
