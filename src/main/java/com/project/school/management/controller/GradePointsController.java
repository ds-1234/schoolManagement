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

import com.project.school.management.dto.GradePointsRequestDto;
import com.project.school.management.entity.MasterGradePoints;
import com.project.school.management.exception.InvalidRequestException;
import com.project.school.management.response.Response;
import com.project.school.management.service.GradePointsService;

@CrossOrigin
@RestController
@RequestMapping("gradePoints")
public class GradePointsController {
	
	@Autowired
	private GradePointsService gradePointsService;
	
	@GetMapping("getGradePointsList")
	public ResponseEntity<Object> getGradePointsList() {
		Response response = new Response();
		response.succeed();
		response.setData(gradePointsService.getGradePointsList());
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("createGradePoints")
	public ResponseEntity<Response> createGradePoints(@RequestBody MasterGradePoints dto) {
		Response response = new Response();
		response.succeed();
		response.setData(gradePointsService.save(dto));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getGradePoints/{id}")
	public ResponseEntity<Object> getGradePoints(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(gradePointsService.getGradePoints(id));
		return ResponseEntity.ok().body(response);

	}
	
	@DeleteMapping("deleteGradePoints/{id}")
	public ResponseEntity<Object> deleteGradePoints(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(gradePointsService.deleteGradePoints(id));
		return ResponseEntity.noContent().build() ;

	}
	
	@PutMapping("updateGradePoints")
	public ResponseEntity<Response> updateGradePoints(@RequestBody GradePointsRequestDto gradePointsRequestDto) {
		if(Objects.isNull(gradePointsRequestDto.getId())) {
			throw new InvalidRequestException();
		}
		Response response = new Response();
		response.succeed();
		response.setData(gradePointsService.updateTransport(gradePointsRequestDto));
		return ResponseEntity.ok().body(response);
	}

}
