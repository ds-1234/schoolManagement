package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.TimeTableEntity;

public interface TimetableService {

	TimeTableEntity addTimetable(TimeTableEntity timeTableEntity);

	List<TimeTableEntity> getTimeTable();

	TimeTableEntity getTimeTableById(Long id);


}
