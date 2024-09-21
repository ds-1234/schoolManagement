package com.project.school.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.TimeTableEntity;
import com.project.school.management.request.TimeTableRequest;
import com.project.school.management.response.Response;
import com.project.school.management.response.TimetableResponse;
import com.project.school.management.service.TimetableService;

@RestController @CrossOrigin
@RequestMapping("timeTable")
public class TimeTableController {
	
	@Autowired
	private TimetableService timetableService;
	
	@PostMapping("/addTimeTable")
    public ResponseEntity<Response> addTimetable(@RequestBody TimeTableEntity timeTableEntity) {
		Response response = new Response();
		response.succeed();
		response.setData(timetableService.addTimetable(timeTableEntity));
		return ResponseEntity.ok().body(response);
    }

}
