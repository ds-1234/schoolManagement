package com.project.school.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ExamTypeDto {
	
	private Long id;
	private String examTypeName;
	private String examTypeDescription;

}
