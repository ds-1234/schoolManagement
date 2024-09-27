package com.project.school.management.request;

import lombok.Data;

@Data
public class LeaveRequest {
	
	Long id;
	String leaveType;
	String leaveDescription;
	Boolean isActive;

}
