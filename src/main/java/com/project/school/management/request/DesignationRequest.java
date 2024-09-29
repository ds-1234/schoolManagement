package com.project.school.management.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class DesignationRequest {
	
	Long id;
	
	String dsignationId;
	
	String designationName;
	
	Boolean isActive;

}
