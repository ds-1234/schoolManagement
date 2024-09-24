package com.project.school.management.service;

import java.util.List;
import java.util.Map;

import com.project.school.management.entity.TimeTableEntity;
import com.project.school.management.request.TimeTableDaysSchedule;
import com.project.school.management.response.TimetableResponse;

public interface TimetableService {

	TimeTableEntity addTimetable(TimeTableEntity timeTableEntity);

	List<TimeTableEntity> getTimeTable();

	TimeTableEntity getTimeTableById(Long id);


}
