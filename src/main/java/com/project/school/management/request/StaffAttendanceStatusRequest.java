package com.project.school.management.request;

import java.sql.Time;
import java.time.LocalTime;

import lombok.Data;

@Data
public class StaffAttendanceStatusRequest {
	Long id;
	LocalTime startTime;
	LocalTime endTime;
	String attendanceStatus;
	Boolean isActive;

}
