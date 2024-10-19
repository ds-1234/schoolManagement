package com.project.school.management.request;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AcademicDetailsRequest {
	
	String userId;
	Long school;
	List<Long> className = new ArrayList<>();
	String academicYear;
	Long rollNumber;

}
