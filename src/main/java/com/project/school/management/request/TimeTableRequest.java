package com.project.school.management.request;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class TimeTableRequest {
	private String className;
    private String section;
    private List<TimeTableDaysSchedule> daySchedules; // Key as Day (Monday, Tuesday, etc.)

}
