package com.project.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.ClassEntity;
import com.project.school.management.response.Response;
import com.project.school.management.service.ClassService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("class")
@Slf4j
public class ClassController {

	@Autowired
	private ClassService classService;

	@PostMapping("createBook")
	public ResponseEntity<Response> createBook(@RequestBody ClassEntity dto) {
		Response response = new Response();
		response.succeed();
		response.setData(classService.save(dto));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getBookList")
	public ResponseEntity<Object> getBookList() {
		Response response = new Response();
		response.succeed();
		response.setData(classService.getList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getBook/{id}")
	public ResponseEntity<Object> getBook(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(classService.getAddress(id));
		return ResponseEntity.ok().body(response);

	}

}
