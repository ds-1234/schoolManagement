package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.school.management.request.HomeworkRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.HomeworkService;

@CrossOrigin
@RestController
@RequestMapping("homework")
public class HomeworkController {
	
	@Autowired
	private HomeworkService homeworkService;
	
	@PostMapping(value = "saveHomework", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> saveHomework(@RequestBody HomeworkRequest homeworkRequest, @RequestParam("file") MultipartFile file) 
								throws IOException
	{
		Response response = new Response();
		response.succeed();
		response.setData(homeworkService.saveHomework(homeworkRequest, file));
		return ResponseEntity.ok().body(response);
	}

}
