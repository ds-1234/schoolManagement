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

import com.project.school.management.request.FeesGroupRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.FeesGroupService;

@CrossOrigin
@RestController
@RequestMapping("feesGroup")
public class FeesGroupController {
	
	@Autowired
	private FeesGroupService feesGroupService;
	
	@PostMapping("saveFeesGroup")
	public ResponseEntity<Response> saveFeesGroup(@RequestBody FeesGroupRequest feesGroupRequest) throws IOException{
		Response response = new Response();
		response.succeed();
		response.setData(feesGroupService.saveFeesGroup(feesGroupRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getFeesGroupList")
	public ResponseEntity<Object> getFeesGroupList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(feesGroupService.getFeesGroupList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getFeesGroupById/{id}")
	public ResponseEntity<Object> getHostelById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(feesGroupService.getFeesGroupById(id));
		return ResponseEntity.ok().body(response);
	}
//	
//	@PostMapping("deleteHostel/{id}")
//	public ResponseEntity<Response> deleteHostel(@PathVariable Long id) {
//		Response response = new Response();
//		response.succeed();
//		response.setData(hostelService.deleteHostel(id));
//		return ResponseEntity.ok().body(response);
//	}


}
