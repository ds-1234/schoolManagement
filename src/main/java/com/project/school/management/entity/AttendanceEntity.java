package com.project.school.management.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@Column(name = "teacher", nullable = false)
    private Long teacher;
	
	@Column(name = "className", nullable = false)
	private Long className;
	
	@Column(name = "attendance_date", nullable = false)
	private Date attendanceDate;
	
	//Present, Absent, Half-Day, Holiday, Medical
//	@Column(name = "attendenceStatus",columnDefinition="text", length=10485760, nullable = false)
//	private String attendenceStatus;
	@ElementCollection
    @CollectionTable(name = "attendance_status", joinColumns = @JoinColumn(name = "attendance_id"))
    @Column(name = "attendance_status")
    private List<AttendanceStatus> attendanceStatusList;
}
