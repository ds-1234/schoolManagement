package com.project.school.management.request;

import java.sql.Date;

import lombok.Data;

@Data
public class HolidayRequest {
	Long id;
	String holidayName;
	Date holidayDate;
	String description;
	Boolean isActive;

}
