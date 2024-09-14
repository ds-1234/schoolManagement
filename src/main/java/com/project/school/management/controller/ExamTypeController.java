package com.project.school.management.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.dto.ExamTypeDto;
import com.project.school.management.entity.MasterExamType;
import com.project.school.management.exception.InvalidRequestException;
import com.project.school.management.response.Response;
import com.project.school.management.service.ExamTypeService;

@CrossOrigin
@RestController
@RequestMapping("examType")
public class ExamTypeController {
	
	@Autowired
	private ExamTypeService examTypeService;
	
	@GetMapping("getExamTypeList")
	public ResponseEntity<Object> getExamTypeList() {
		Response response = new Response();
		response.succeed();
		response.setData(examTypeService.getExamTypeList());
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("createExamType")
	public ResponseEntity<Response> createExamType(@RequestBody MasterExamType dto) {
		Response response = new Response();
		response.succeed();
		response.setData(examTypeService.save(dto));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExamType/{id}")
	public ResponseEntity<Object> getExamType(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(examTypeService.getTransport(id));
		return ResponseEntity.ok().body(response);

	}
	
	@PutMapping("updateExamType")
	public ResponseEntity<Response> updateExamType(@RequestBody ExamTypeDto examTypeDto) {
		if(Objects.isNull(examTypeDto.getId())) {
			throw new InvalidRequestException();
		}
		Response response = new Response();
		response.succeed();
		response.setData(examTypeService.updateExamType(examTypeDto));
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping("deleteExamType/{id}")
	public ResponseEntity<Object> deleteExamType(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(examTypeService.deleteExamType(id));
		return ResponseEntity.noContent().build() ;

	}

}
