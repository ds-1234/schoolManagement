package com.project.school.management.dto;

import lombok.Data;

@Data
public class StudentMarksDto {
	Long id;
	Long studentId;
	Long examMarks;
	String remarks;

}
