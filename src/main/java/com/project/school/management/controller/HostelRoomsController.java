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

import com.project.school.management.request.HostelRoomsRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.HostelRoomsService;

@CrossOrigin
@RestController
@RequestMapping("hostelRooms")
public class HostelRoomsController {
	
	@Autowired
	private HostelRoomsService hostelRoomsService;
	
	@PostMapping("saveHostelRooms")
	public ResponseEntity<Response> saveHostelRooms(@RequestBody HostelRoomsRequest hostelRoomsRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(hostelRoomsService.saveHostelRooms(hostelRoomsRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getHostelRoomsList")
	public ResponseEntity<Object> getHostelRoomsList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(hostelRoomsService.getHostelRoomsList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getHostelRoomsById/{id}")
	public ResponseEntity<Object> getHostelRoomsById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(hostelRoomsService.getHostelRoomsById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteHostelRooms/{id}")
	public ResponseEntity<Response> deleteHostelRooms(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(hostelRoomsService.deleteHostelRooms(id));
		return ResponseEntity.ok().body(response);
	}


}
