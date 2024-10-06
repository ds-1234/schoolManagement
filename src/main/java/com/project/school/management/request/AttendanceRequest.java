package com.project.school.management.request;

import java.util.Date;

import lombok.Data;
@Data
public class AttendanceRequest {
	
	Long id;
	
	Long studentId;
	
    Long teacherId;
	
	Long classId;
	
	Date attendanceDate;
	
	String attendanceStatus;

}
