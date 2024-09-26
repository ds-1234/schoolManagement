package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.request.HolidayRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.HolidayService;

@CrossOrigin
@RestController
@RequestMapping("holidays")
public class HolidaysController {
	
	@Autowired
	private HolidayService holidayService;
	
	@PostMapping("saveholidays")
	public ResponseEntity<Response> saveholiday(@RequestBody HolidayRequest holidayRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(holidayService.saveholiday(holidayRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getHolidaysList")
	public ResponseEntity<Object> getHolidaysList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(holidayService.getHolidaysList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getHolidayById/{id}")
	public ResponseEntity<Object> getHolidayById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(holidayService.getHolidayById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteholidays/{id}")
	public ResponseEntity<Response> deleteholidays(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(holidayService.deleteholidays(id));
		return ResponseEntity.ok().body(response);
	}

}
