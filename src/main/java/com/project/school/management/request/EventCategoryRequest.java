package com.project.school.management.request;

import lombok.Data;

@Data
public class EventCategoryRequest {
	
	Long id;

	String eventCategoryTitle;
	
	String eventCatColorCode;

	Boolean isActive;

}
