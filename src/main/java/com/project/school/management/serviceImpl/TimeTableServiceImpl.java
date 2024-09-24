package com.project.school.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.entity.TimeTableEntity;
import com.project.school.management.repository.TimetableRepository;
import com.project.school.management.service.TimetableService;

@Service
public class TimeTableServiceImpl implements TimetableService {

	@Autowired
	private TimetableRepository timetableRepository;
	
	@Autowired
    private ObjectMapper objectMapper;

	@Override
	public TimeTableEntity addTimetable(TimeTableEntity timeTableEntity) {
		return timetableRepository.save(timeTableEntity);
	}

	@Override
	public List<TimeTableEntity> getTimeTable() {
		return this.timetableRepository.findAll();
	}

	
}
