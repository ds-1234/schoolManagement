package com.project.school.management.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RoomTypeRequest {
	
	Long id;
	
	String roomTypeName;
	
	String description;
	
	Boolean isActive;

}
