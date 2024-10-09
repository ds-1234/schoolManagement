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

import com.project.school.management.request.FeesCollectionRequest;
import com.project.school.management.request.FeesGroupRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.FeesCollectionService;
import com.project.school.management.service.FeesGroupService;

@CrossOrigin
@RestController
@RequestMapping("feesCollection")
public class FeesCollectionController {
	
	@Autowired
	private FeesCollectionService feesCollectionService;
	
	@PostMapping("savefeesCollection")
	public ResponseEntity<Response> savefeesCollection(@RequestBody FeesCollectionRequest feesCollectionRequest) throws IOException{
		Response response = new Response();
		response.succeed();
		response.setData(feesCollectionService.savefeesCollection(feesCollectionRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getFeesCollectionList")
	public ResponseEntity<Object> getFeesCollectionList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(feesCollectionService.getFeesCollectionList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getFeesCollectionById/{id}")
	public ResponseEntity<Object> getFeesCollectionById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(feesCollectionService.getFeesCollectionById(id));
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
