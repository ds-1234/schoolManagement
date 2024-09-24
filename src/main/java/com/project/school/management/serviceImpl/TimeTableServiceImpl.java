package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.entity.TimeTableEntity;
import com.project.school.management.exception.InvalidArgumentException;
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

	@Override
	public TimeTableEntity getTimeTableById(Long id) {
		Optional<TimeTableEntity> dbData = timetableRepository.findById(id);
		if(dbData.isEmpty()) {
			throw new InvalidArgumentException("Given Id is invalid or empty");
		}
		return dbData.get();
	}

	
}
