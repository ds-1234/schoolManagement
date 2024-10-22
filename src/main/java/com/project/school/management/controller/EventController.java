package com.project.school.management.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.school.management.request.EventRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.EventService;

@CrossOrigin
@RestController
@RequestMapping("events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("saveEvent")
	public ResponseEntity<Response> saveEvent(@RequestBody EventRequest eventRequest) throws IOException{
		Response response = new Response();
		response.succeed();
		response.setData(eventService.saveEvent(eventRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getEventList")
	public ResponseEntity<Object> getEventList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(eventService.getEventList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getEventById/{id}")
	public ResponseEntity<Object> getEventById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(eventService.getEventById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteEvent/{id}")
	public ResponseEntity<Response> deleteEvent(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(eventService.deleteEvent(id));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getEventListByCatId/{catId}")
	public ResponseEntity<Object> getEventListByCatId(@PathVariable Long catId) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(eventService.getEventListByCatId(catId));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getEventByCalandarType")
	public ResponseEntity<Object> getEventByCalandarType(
			@RequestParam(required = false) String type, //"month", "week","date"
			@RequestParam(required = false) LocalDate date,
			@RequestParam(required = false) Integer month,
			@RequestParam(required = false) Integer year,
			@RequestParam(required = false) String dateRange) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(eventService.getEventByCalandarType(type, date, month, year, dateRange));
		return ResponseEntity.ok().body(response);
	}


}
