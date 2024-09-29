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

import com.project.school.management.request.HostelRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.HostelService;

@CrossOrigin
@RestController
@RequestMapping("hostel")
public class HostelController {
	
	@Autowired
	private HostelService hostelService;
	
	@PostMapping("saveHostel")
	public ResponseEntity<Response> saveHostel(@RequestBody HostelRequest hostelRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(hostelService.saveHostel(hostelRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getHostelList")
	public ResponseEntity<Object> getHostelList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(hostelService.getHostelList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getHostelById/{id}")
	public ResponseEntity<Object> getHostelById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(hostelService.getHostelById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteHostel/{id}")
	public ResponseEntity<Response> deleteHostel(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(hostelService.deleteHostel(id));
		return ResponseEntity.ok().body(response);
	}


}
