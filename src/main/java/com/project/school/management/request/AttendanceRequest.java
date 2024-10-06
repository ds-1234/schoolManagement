package com.project.school.management.request;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
@Data
public class AttendanceRequest {
	
	Long id;
	
    Long teacher;
	
	Long className;
	
	Date attendanceDate;
	
	Map<String, String> attendenceStatus = new HashMap();

}
