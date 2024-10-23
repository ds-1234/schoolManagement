package com.project.school.management.request;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class EventRequest {

	Long id;

	String eventTitle;

	List<Long> role;
	
	List<Long> user;
	
	List<Long> className;

	Long eventCategory;

	Date startDate;

	Date endDate;

	String startTime;

	String endTime;

	String message;

	Boolean isActive;

}
