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

import com.project.school.management.request.LeaveRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.LeavesService;

@CrossOrigin
@RestController
@RequestMapping("leaves")
public class LeaveController {
	
	@Autowired
	private LeavesService leavesService;
	
	@PostMapping("saveLeaves")
	public ResponseEntity<Response> saveLeaves(@RequestBody LeaveRequest leaveRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(leavesService.saveLeaves(leaveRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getLeavesList")
	public ResponseEntity<Object> getLeavesList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(leavesService.getLeavesList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getLeaveById/{id}")
	public ResponseEntity<Object> getLeaveById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(leavesService.getLeaveById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteLeaveById/{id}")
	public ResponseEntity<Response> deleteLeaveById(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(leavesService.deleteLeaveById(id));
		return ResponseEntity.ok().body(response);
	}

}
