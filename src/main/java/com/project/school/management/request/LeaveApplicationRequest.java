package com.project.school.management.request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class LeaveApplicationRequest {
	Long senderId;
	Long leaveAuthoriserId;
	String rollOrEmployeeId;
	Long leaveType;
	LocalDate leaveStartDate;
	LocalDate leaveEndDate;
	String leaveReason;
	
	

}
