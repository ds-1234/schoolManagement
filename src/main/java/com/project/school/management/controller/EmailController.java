package com.project.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.response.Response;
import com.project.school.management.utility.MailUtils;

@CrossOrigin
@RestController
@RequestMapping("email")
public class EmailController {

	
	@Autowired
	private MailUtils mailUtils;

	@GetMapping("sendEmail")
	public ResponseEntity<Response> createClass() {
		Response response = new Response();
		response.succeed();
		mailUtils.sendEmail("kshsarswat@gmail.com","akysharma.193@gmail.com","Test","Test");
		return ResponseEntity.ok().body(response);
	}
}
