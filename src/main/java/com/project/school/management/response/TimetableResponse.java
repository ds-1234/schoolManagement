package com.project.school.management.response;

import java.util.Map;

import lombok.Data;

@Data
public class TimetableResponse {
	private Long id;
	private String className;
	private String section;
	private Map<String, Object> timeTable; // Beautified JSON structure

	public TimetableResponse(Long id, String className, String section, Map<String, Object> timeTable) {
	        this.id = id;
	        this.className = className;
	        this.section = section;
	        this.timeTable = timeTable;
	}
}
