package com.project.school.management.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name ="staff_attendance_status")
public class StaffAttendanceStatusEntity {
	@Id
	private Long id;
	
	@Column(name = "start_time")
	private LocalTime startTime;
	
	@Column(name = "end_time")
	private LocalTime endTime;
	
	@Column(name = "attendance_status")
	private String attendanceStatus;
	
	@Column(name = "color_code")
	private String colorCode;
	
	@Column(name = "status")
	private Boolean isActive;

}
