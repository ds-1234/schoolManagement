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

import com.project.school.management.request.RoomTypeRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.RoomTypeService;

@CrossOrigin
@RestController
@RequestMapping("roomType")
public class RoomTypeController {
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@PostMapping("saveRoomType")
	public ResponseEntity<Response> saveRoomType(@RequestBody RoomTypeRequest roomTypeRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(roomTypeService.saveRoomType(roomTypeRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getRoomTypeList")
	public ResponseEntity<Object> getRoomTypeList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(roomTypeService.getRoomTypeList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getRoomTypeById/{id}")
	public ResponseEntity<Object> getRoomTypeById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(roomTypeService.getRoomTypeById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteRoomType/{id}")
	public ResponseEntity<Response> deleteRoomType(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(roomTypeService.deleteRoomType(id));
		return ResponseEntity.ok().body(response);
	}


}
