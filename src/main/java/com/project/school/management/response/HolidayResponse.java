package com.project.school.management.response;

import java.util.Date;

import lombok.Data;

@Data
public class HolidayResponse {
	
	String holidayId;
	String holidayName;
	String holidayType;
	Date startDate;
	Date endDate;

}
