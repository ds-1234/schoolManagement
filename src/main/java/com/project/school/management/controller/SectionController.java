package com.project.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.Section;
import com.project.school.management.response.Response;
import com.project.school.management.service.SectionService;

@RestController
@RequestMapping("section")
public class SectionController {

	@Autowired
	private SectionService sectionService;

	@PostMapping("createSection")
	public ResponseEntity<Response> createSection(@RequestBody Section dto) {
		Response response = new Response();
		response.succeed();
		response.setData(sectionService.save(dto));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getSectionList")
	public ResponseEntity<Object> getSectionList() {
		Response response = new Response();
		response.succeed();
		response.setData(sectionService.getList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getSection/{id}")
	public ResponseEntity<Object> getSection(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(sectionService.getAddress(id));
		return ResponseEntity.ok().body(response);

	}

}
