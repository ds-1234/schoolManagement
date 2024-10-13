package com.project.school.management.request;

import lombok.Data;

@Data
public class PreviousSchoolDetailsRequest {
	String userId;
	String previousSchoolName;
	String preSchoolAddress;
	String preSchoolLeavingSession;
	Boolean status;

}
