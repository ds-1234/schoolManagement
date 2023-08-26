package com.project.school.management.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.HolidayEntity;
import com.project.school.management.entity.RoleEntity;
import com.project.school.management.service.ManagementService;

@RestController
@RequestMapping("/management")
public class ManagementController {
	
	private static final Logger log = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	private ManagementService managementService;
	
	@PostMapping("/saveHoliday")
	public ResponseEntity<Object> saveHoliday(@RequestBody HolidayEntity holidayEntity) throws IOException{
		log.info("******API Start For save holiday******");
				return managementService.saveHoliday(holidayEntity);	
	}

}
