package com.project.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.school.management.entity.TransportEntity;
import com.project.school.management.response.Response;
import com.project.school.management.service.TransportService;

@CrossOrigin
@RestController
@RequestMapping("transport")
public class TransportController {
	
	@Autowired
	private TransportService transportService;
	
	@GetMapping("getTransportList")
	public ResponseEntity<Object> getTransportList() {
		Response response = new Response();
		response.succeed();
		response.setData(transportService.getList());
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("createTransport")
	public ResponseEntity<Response> createTransport(@RequestBody TransportEntity dto) {
		Response response = new Response();
		response.succeed();
		response.setData(transportService.save(dto));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getTransport/{id}")
	public ResponseEntity<Object> getTransport(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(transportService.getTransport(id));
		return ResponseEntity.ok().body(response);

	}

}
