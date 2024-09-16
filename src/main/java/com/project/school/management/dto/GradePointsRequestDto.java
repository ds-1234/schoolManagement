package com.project.school.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class GradePointsRequestDto {
	
	private Long id;
	private String grade;
	private String percentageFrom;
	private String percentageUpto;
	private String gradePoints;
	private String description;

}
