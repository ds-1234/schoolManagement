package com.project.school.management.serviceImpl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.HolidayEntity;
import com.project.school.management.service.ManagementService;

@Service
public class ManagementServiceImpl implements ManagementService{
	
	private static final Logger log = LoggerFactory.getLogger(ManagementServiceImpl.class);

	@Override
	public ResponseEntity<Object> saveHoliday(HolidayEntity holidayEntity) throws IOException {
		return null;
	}

}
