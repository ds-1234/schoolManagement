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

import com.project.school.management.entity.ClassEntity;
import com.project.school.management.response.Response;
import com.project.school.management.service.ClassService;

@CrossOrigin
@RestController
@RequestMapping("class")
public class ClassController {

	@Autowired
	private ClassService classService;

	@PostMapping("createClass")
	public ResponseEntity<Response> createClass(@RequestBody ClassEntity dto) {
		Response response = new Response();
		response.succeed();
		response.setData(classService.save(dto));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getClassList")
	public ResponseEntity<Object> getClassList() {
		Response response = new Response();
		response.succeed();
		response.setData(classService.getList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getClass/{id}")
	public ResponseEntity<Object> getClass(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(classService.getAddress(id));
		return ResponseEntity.ok().body(response);

	}

}
