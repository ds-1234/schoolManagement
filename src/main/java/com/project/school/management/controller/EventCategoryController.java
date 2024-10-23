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

import com.project.school.management.request.EventCategoryRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.EventCategoryService;

@CrossOrigin
@RestController
@RequestMapping("eventCategory")
public class EventCategoryController {
	
	@Autowired
	private EventCategoryService eventCategoryService;
	
	@PostMapping("saveEventCategory")
	public ResponseEntity<Response> saveEventCategory(@RequestBody EventCategoryRequest eventCategoryRequest) throws IOException{
		Response response = new Response();
		response.succeed();
		response.setData(eventCategoryService.saveEventCategory(eventCategoryRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getEventCatList")
	public ResponseEntity<Object> getEventCatList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(eventCategoryService.getEventCatList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getEventCatById/{id}")
	public ResponseEntity<Object> getEventCatById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(eventCategoryService.getEventCatById(id));
		return ResponseEntity.ok().body(response);
	}
	
//	@PostMapping("deleteEventCat/{id}")
//	public ResponseEntity<Response> deleteHostel(@PathVariable Long id) {
//		Response response = new Response();
//		response.succeed();
//		response.setData(hostelService.deleteHostel(id));
//		return ResponseEntity.ok().body(response);
//	}


}