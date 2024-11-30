package com.project.school.management.request;


import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.school.management.entity.AttendanceStatus;

import lombok.Data;
@Data
public class AttendanceRequest {
	
	Long id;
	
    Long teacher;
	
	Long className;
	
	Date attendanceDate;
	
    List<AttendanceStatus> attendanceStatusList;

}
