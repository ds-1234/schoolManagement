package com.project.school.management.controller;

import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.request.BookIssueRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.LibraryService;

@CrossOrigin
@RestController
@RequestMapping("library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@PostMapping("saveBookIssued")
	public ResponseEntity<Response> saveBookIssued(@RequestBody BookIssueRequest bookIssueRequest) throws IOException{
		Response response = new Response();
		response.succeed();
		response.setData(libraryService.saveBookIssued(bookIssueRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getBookIssued")
	public ResponseEntity<Response> getBookIssued() throws IOException{
		Response response = new Response();
		response.succeed();
		response.setData(libraryService.getBookIssued());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getBookIssuedById/{id}")
	public ResponseEntity<Response> getBookIssuedById(@PathVariable Long id) throws IOException{
		if(Objects.isNull(id)) {
			throw new InvalidArgumentException("Given id is null");
		}
		Response response = new Response();
		response.succeed();
		response.setData(libraryService.getBookIssuedById(id));
		return ResponseEntity.ok().body(response);
	}

}
