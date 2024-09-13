package com.project.school.management.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.dto.TransportRequestDto;
import com.project.school.management.entity.TransportEntity;
import com.project.school.management.exception.InvalidRequestException;
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
	@PutMapping("updateTransport")
	public ResponseEntity<Response> updateTransport(@RequestBody TransportRequestDto transportRequestDto) {
		if(Objects.isNull(transportRequestDto.getId())) {
			throw new InvalidRequestException();
		}
		Response response = new Response();
		response.succeed();
		response.setData(transportService.updateTransport(transportRequestDto));
		return ResponseEntity.ok().body(response);
	}
	@PutMapping("changeStatus/{id}")
	public ResponseEntity<Object> changeStatus(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		transportService.changeStatus(id);
		response.setData("Status updated Successfully");
		return ResponseEntity.noContent().build() ;

	}
	
	@DeleteMapping("deleteTransport/{id}")
	public ResponseEntity<Object> deleteTransport(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(transportService.deleteTransport(id));
		return ResponseEntity.noContent().build() ;

	}

}
