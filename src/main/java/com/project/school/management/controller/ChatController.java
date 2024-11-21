package com.project.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.request.AttendanceRequest;
import com.project.school.management.request.MessageRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.ChatService;

@CrossOrigin
@RestController
@RequestMapping("chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@PostMapping("sendMessage")
	public ResponseEntity<Response> sendMessage(@RequestBody MessageRequest messageRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(chatService.sendMessage(messageRequest));
		return ResponseEntity.ok().body(response);
	}

}
