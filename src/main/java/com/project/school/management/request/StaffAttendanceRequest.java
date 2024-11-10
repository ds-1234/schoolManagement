package com.project.school.management.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class StaffAttendanceRequest {
	Long id;
	Long userTableId;
	LocalDateTime logindateTime;
	double latitude;
	double longitude;

}
