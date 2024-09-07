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

import com.project.school.management.constant.Message;
import com.project.school.management.entity.Subject;
import com.project.school.management.response.Response;
import com.project.school.management.service.SubjectService;

@CrossOrigin
@RestController
@RequestMapping("subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@PostMapping("createSubject")
	public ResponseEntity<Response> createSubject(@RequestBody Subject dto) {
		Response response = new Response();
		response.succeed();
		response.setData(subjectService.save(dto));
		response.setMessage(Message.SUBJECT_CREATED_SUCCESSFULLY);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getSubjectList")
	public ResponseEntity<Object> getSubjectList() {
		Response response = new Response();
		response.succeed();
		response.setData(subjectService.getList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getSubject/{id}")
	public ResponseEntity<Object> getSubject(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(subjectService.getAddress(id));
		return ResponseEntity.ok().body(response);

	}

}
