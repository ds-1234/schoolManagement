package com.project.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.dto.TeacherInfoDto;
import com.project.school.management.response.Response;
import com.project.school.management.service.TeacherInfoService;

@CrossOrigin
@RestController
@RequestMapping("teacherInfo")
public class TeacherInfoController {

	@Autowired
	private TeacherInfoService teacherInfoService;

	@PostMapping("createTeacherInfo")
	public ResponseEntity<Response> createTeacherInfo(@RequestBody TeacherInfoDto dto) {
		Response response = new Response();
		response.succeed();
		response.setData(teacherInfoService.createTeacherInfo(dto));
		return ResponseEntity.ok().body(response);
	}


	@GetMapping("getTeacherInfo/{id}")
	public ResponseEntity<Object> getTeacherInfo(@PathVariable String id) {
		Response response = new Response();
		response.succeed();
		response.setData(teacherInfoService.getTeacherInfo(id));
		return ResponseEntity.ok().body(response);

	}
	
	@GetMapping("getClassSubjectInfo/{id}")
	public ResponseEntity<Object> getClassSubjectInfo(@PathVariable String id) {
		Response response = new Response();
		response.succeed();
		response.setData(teacherInfoService.getClassSubjectInfo(id));
		return ResponseEntity.ok().body(response);

	}
	
	@GetMapping("getClassSubjectInfoData")
	public ResponseEntity<Object> getClassSubjectInfoData() {
		Response response = new Response();
		response.succeed();
		response.setData(teacherInfoService.getClassSubjectInfoData());
		return ResponseEntity.ok().body(response);

	}

}
