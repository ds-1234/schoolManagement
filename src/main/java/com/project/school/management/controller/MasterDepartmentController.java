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

import com.project.school.management.request.DepartmentRequest;
import com.project.school.management.request.IncomeRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.IncomeService;
import com.project.school.management.service.MasterDepartmentService;

@CrossOrigin
@RestController
@RequestMapping("department")
public class MasterDepartmentController {
	
	@Autowired
	private MasterDepartmentService masterDepartmentService;
	
	@PostMapping("saveDepartment")
	public ResponseEntity<Response> saveDepartment(@RequestBody DepartmentRequest departmentRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(masterDepartmentService.saveDepartment(departmentRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getDepartmentList")
	public ResponseEntity<Object> getDepartmentList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(masterDepartmentService.getDepartmentList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getDepartmentById/{id}")
	public ResponseEntity<Object> getDepartmentById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(masterDepartmentService.getDepartmentById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteDepartment/{id}")
	public ResponseEntity<Response> deleteDepartment(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(masterDepartmentService.deleteDepartment(id));
		return ResponseEntity.ok().body(response);
	}

}
