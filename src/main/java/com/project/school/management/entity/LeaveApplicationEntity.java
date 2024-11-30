package com.project.school.management.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Table(name ="leave_application_entity")
@Entity
public class LeaveApplicationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "leave_application_id", nullable = false)
	private String leaveApplicationId;
	
	@Column(name = "sender_id", nullable = false)
	private Long senderId;
	
	@Column(name = "leave_authoriser_id", nullable = false)
	private Long leaveAuthoriserId;
	
	@Column(name = "roll_no_employee_id")
	private String rollOrEmployeeId;
	
	@Column(name = "leave_type", nullable = false)
	private Long leaveType;
	
	@Column(name = "leave_start_date", nullable = false)
	private LocalDate leaveStartDate;
	
	@Column(name = "leave_end_date", nullable = false)
	private LocalDate leaveEndDate;
	
	@Column(name = "leave_day_duration", nullable = false)
	private Integer leaveDayDuration;
	
	@Column(name = "appliedOn", nullable = false)
	private LocalDate appliedOn;
	
	@Column(name = "leave_reason", nullable = false)
	private String leaveReason;
	
	@Column(name = "leave_status", nullable = false)
	private String leaveStatus;
	
	@Column(name = "leave_rejection_reason", nullable = false)
	private String leaveRejectionReason;

}
