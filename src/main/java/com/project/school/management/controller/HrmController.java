package com.project.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.school.management.request.ExamScheduleRequest;
import com.project.school.management.request.HrmDetailsDto;
import com.project.school.management.request.PaySlipRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.HrmService;

@CrossOrigin
@RestController
@RequestMapping("hrm")
public class HrmController {
	
	@Autowired
	private HrmService hrmService;
	
	@PostMapping("saveHrmDetails")
	public ResponseEntity<Response> saveHrmDetails(@RequestBody HrmDetailsDto hrmDetailsDto) {
		Response response = new Response();
		response.succeed();
		response.setData(hrmService.saveHrmDetails(hrmDetailsDto));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getLeaveCounterDetailsById/{staffId}")
	public ResponseEntity<Response> getLeaveCounterDetailsById(@PathVariable Long staffId) {
		Response response = new Response();
		response.succeed();
		response.setData(hrmService.getLeaveCounterDetailsById(staffId));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("paySlipCreator")
	public ResponseEntity<Response> paySlipCreator(@RequestBody PaySlipRequest paySlipRequest) throws JsonProcessingException{
		Response response = new Response();
		response.succeed();
		response.setData(hrmService.paySlipCreator(paySlipRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("getPaySlipById")
	public ResponseEntity<Response> getPaySlipById(@RequestParam String staffId, @RequestParam String payPeriod) throws JsonProcessingException{
		Response response = new Response();
		response.succeed();
		response.setData(hrmService.getPaySlipById(staffId, payPeriod));
		return ResponseEntity.ok().body(response);
	}
	
	

}
