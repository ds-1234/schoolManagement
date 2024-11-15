package com.project.school.management.request;

import java.sql.Date;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class SubjectWiseExamList {
	Date examDate;
	Long subject;
	LocalTime startTime;
	LocalTime endTime;
	String duration;
	String maxMarks;
	String minMarks;

}
