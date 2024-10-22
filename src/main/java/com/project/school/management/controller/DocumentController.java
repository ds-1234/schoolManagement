package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.school.management.response.Response;
import com.project.school.management.service.DocumentService;

@CrossOrigin
@RestController
@RequestMapping("document")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;

	
	@PostMapping(value = "saveDocument/{id}")
	public ResponseEntity<Response> saveDocument(@RequestParam("files") MultipartFile[] files, @PathVariable String id) 
								throws IOException
	{
		Response response = new Response();
		response.succeed();
		documentService.saveDocument(files, id);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value = "getDocument/{id}")
	public ResponseEntity<Response> getDocument(@PathVariable String id) 
								throws IOException
	{
		Response response = new Response();
		response.setData(documentService.getDocument(id));
		response.succeed();
		return ResponseEntity.ok().body(response);
	}
}
