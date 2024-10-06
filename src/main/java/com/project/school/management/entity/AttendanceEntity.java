package com.project.school.management.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "attendance")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "attendance_id", nullable = false)
	private String attendanceId;
	
	@Column(name = "user_student_id", nullable = false)
    private Long userStudentId;
	
	@Column(name = "user_teacher_id", nullable = false)
    private Long userTeacherId;
	
	@Column(name = "class_id", nullable = false)
	private Long classId;
	
	@Column(name = "attendance_date", nullable = false)
	private Date attendanceDate;
	
	//Present, Absent, Half-Day, Holiday, Medical
	@Column(name = "attendance_status", nullable = false)
	private String attendanceStatus;

}
