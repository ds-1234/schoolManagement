package com.project.school.management.request;

import lombok.Data;

@Data
public class UpdateLeavesStatusRequest {
	Long id;
	String leaveStatus;
	String leaveRejectionReason;

}
