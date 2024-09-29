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

import com.project.school.management.request.DesignationRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.MasterDesignationService;

@CrossOrigin
@RestController
@RequestMapping("designation")
public class MasterDesignationController {
	
	@Autowired
	private MasterDesignationService masterDesignationService;
	
	@PostMapping("saveDesignation")
	public ResponseEntity<Response> saveDesignation(@RequestBody DesignationRequest designationRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(masterDesignationService.saveDesignation(designationRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getDesignationList")
	public ResponseEntity<Object> getDesignationList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(masterDesignationService.getDesignationList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getDesignationById/{id}")
	public ResponseEntity<Object> getDesignationById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(masterDesignationService.getDesignationById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteDesignation/{id}")
	public ResponseEntity<Response> deleteDesignation(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(masterDesignationService.deleteDesignation(id));
		return ResponseEntity.ok().body(response);
	}

}
