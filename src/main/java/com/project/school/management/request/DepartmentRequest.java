package com.project.school.management.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class DepartmentRequest {
	
	Long id;
	
	String departmentId;
	
	String departmentName;
	
	Boolean isActive;

}
