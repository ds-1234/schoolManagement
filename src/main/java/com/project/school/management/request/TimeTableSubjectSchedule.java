package com.project.school.management.request;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class TimeTableSubjectSchedule {
	private String subjectName;
    private String teacherName;
    private LocalTime startTime;
    private LocalTime endTime;

}
