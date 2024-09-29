package com.project.school.management.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class HostelRequest {
	
	Long id;
	
	String hostelName;
	
	String hostelType;
	
	Long intakeBedCount;
	
	String hostelAddress;
	
	String description;
	
	Boolean isActive;

}
