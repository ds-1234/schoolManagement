package com.project.school.management.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.project.school.management.entity.HolidayEntity;

public interface ManagementService {

	ResponseEntity<Object> saveHoliday(HolidayEntity holidayEntity) throws IOException;

}
