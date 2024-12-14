package com.project.school.management.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.exception.InvalidRequestException;
import com.project.school.management.request.ExamResultRequest;
import com.project.school.management.request.ExamResultRequestForAdmin;
import com.project.school.management.request.ExamScheduleRequest;
import com.project.school.management.request.StudentExamResultRequest;
import com.project.school.management.request.UpdateExamScheduleRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.ExamService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("exam")
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@Valid
	@PostMapping("saveExam")
	public ResponseEntity<Response> saveExam(@RequestBody ExamScheduleRequest examScheduleRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(examService.saveExam(examScheduleRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("updateExam")
	public ResponseEntity<Response> updateExam(@RequestBody UpdateExamScheduleRequest updateExamScheduleRequest) {
		if(Objects.isNull(updateExamScheduleRequest.getId())) {
			throw new InvalidRequestException("Given Id is null or empty");
		}
		Response response = new Response();
		response.succeed();
		response.setData(examService.updateExam(updateExamScheduleRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExam")
	public ResponseEntity<Response> getExam() {
		Response response = new Response();
		response.succeed();
		response.setData(examService.getExam());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExamById/{id}")
	public ResponseEntity<Response> getExamById(@PathVariable Long id) {
		if(Objects.isNull(id)) {
			throw new InvalidRequestException("Given id is null or empty");
		}
		Response response = new Response();
		response.succeed();
		response.setData(examService.getExamById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getSubjectFromExamListById/{id}")
	public ResponseEntity<Response> getSubjectFromExamListById(@PathVariable Long id) {
		if(Objects.isNull(id)) {
			throw new InvalidRequestException("Given id is null or empty");
		}
		Response response = new Response();
		response.succeed();
		response.setData(examService.getSubjectFromExamListById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteExam/{id}")
	public ResponseEntity<Response> deleteExam(@PathVariable Long id) {
		if(Objects.isNull(id)) {
			throw new InvalidRequestException("Given id is null or empty");
		}
		Response response = new Response();
		response.succeed();
		response.setData(examService.deleteExam(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteSubjectFromExamList/{id}")
	public ResponseEntity<Response> deleteSubjectFromExamList(@PathVariable Long id) {
		if(Objects.isNull(id)) {
			throw new InvalidRequestException("Given id is null or empty");
		}
		Response response = new Response();
		response.succeed();
		response.setData(examService.deleteSubjectFromExamList(id));
		return ResponseEntity.ok().body(response);
	}
	
	
	@PostMapping("saveExamResult")
	public ResponseEntity<Response> saveExamResult(@RequestBody @Validated  ExamResultRequest examResultRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(examService.saveExamResult(examResultRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExamResult")
	public ResponseEntity<Response> getExamResult() {
		Response response = new Response();
		response.succeed();
		response.setData(examService.getExamResult());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExamListByTeacherId/{teacherId}/{examType}/{className}")
	public ResponseEntity<Response> getExamListByTeacherId(@PathVariable Long teacherId,
			@PathVariable Long examType, 
			@PathVariable Long className) {
		if(Objects.isNull(teacherId) || Objects.isNull(examType) || Objects.isNull(className)) {
			throw new InvalidRequestException("Given id is null or empty");
		}
		Response response = new Response();
		response.succeed();
		response.setData(examService.getExamListByTeacherId(teacherId, examType, className));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExamListByStudentId/{studentId}")
	public ResponseEntity<Response> getExamListByStudentId(@PathVariable Long studentId) {
		if(Objects.isNull(studentId)) {
			throw new InvalidRequestException("Given id is null or empty");
		}
		Response response = new Response();
		response.succeed();
		response.setData(examService.getExamListByStudentId(studentId));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExamResultById")
	public ResponseEntity<Response> getExamResultById(@RequestBody StudentExamResultRequest studentExamResultRequest ) {
		if(Objects.isNull(studentExamResultRequest)) {
			throw new InvalidRequestException("Given id is null or empty");
		}
		Response response = new Response();
		response.succeed();
		response.setData(examService.getExamResultById(studentExamResultRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExamResultForAdmin")
	public ResponseEntity<Response> getExamResultForAdmin(@RequestBody ExamResultRequestForAdmin examResultRequestForAdmin ) {
		if(Objects.isNull(examResultRequestForAdmin)) {
			throw new InvalidRequestException("Given id is null or empty");
		}
		Response response = new Response();
		response.succeed();
		response.setData(examService.getExamResultForAdmin(examResultRequestForAdmin));
		return ResponseEntity.ok().body(response);
	}
	

}
