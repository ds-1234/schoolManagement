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

import com.project.school.management.request.AttendanceRequest;
import com.project.school.management.request.StaffAttendanceRequest;
import com.project.school.management.request.StaffAttendanceStatusRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.AttendanceService;

@CrossOrigin
@RestController
@RequestMapping("attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@PostMapping("saveAttendance")
	public ResponseEntity<Response> saveAttendance(@RequestBody AttendanceRequest attendanceRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(attendanceService.saveAttendance(attendanceRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getAttendanceList")
	public ResponseEntity<Object> getAttendanceList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(attendanceService.getAttendanceList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getAttendanceById/{id}")
	public ResponseEntity<Object> getAttendanceById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(attendanceService.getAttendanceById(id));
		return ResponseEntity.ok().body(response);
	}
	
//	@PostMapping("deleteAttendance/{id}")
//	public ResponseEntity<Response> deleteAttendance(@PathVariable Long id) {
//		Response response = new Response();
//		response.succeed();
//		response.setData(attendanceService.deleteAttendance(id));
//		return ResponseEntity.ok().body(response);
//	}
	
	@PostMapping("saveStaffAttendanceStatus")
	public ResponseEntity<Response> saveStaffAttendanceStatus(@RequestBody StaffAttendanceStatusRequest staffAttendanceStatusRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(attendanceService.saveStaffAttendanceStatus(staffAttendanceStatusRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getStaffAttendanceStatus")
	public ResponseEntity<Object> getStaffAttendanceStatus() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(attendanceService.getStaffAttendanceStatus());
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("saveStaffAttendance")
	public ResponseEntity<Response> saveStaffAttendance(@RequestBody StaffAttendanceRequest staffAttendanceRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(attendanceService.saveStaffAttendanceStatus(staffAttendanceRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getStaffAttendance")
	public ResponseEntity<Object> getStaffAttendance() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(attendanceService.getStaffAttendance());
		return ResponseEntity.ok().body(response);
	}

}
