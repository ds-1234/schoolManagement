package com.project.school.management.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name ="staff_attendance")
public class StaffAttendanceEntity {
	
	@Id
	private Long id;
	
	@Column(name = "user_table_id")
	private Long userTableId;
	
	@Column(name = "login_date_time")
	private LocalDateTime logindateTime;
	
	@Column(name = "logout_date_time")
	private LocalDateTime logoutdateTime;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "attendance_status")
	private String attendanceStatus;
	
	@Column(name = "attendance_date")
	private LocalDate attendanceDate;

}
