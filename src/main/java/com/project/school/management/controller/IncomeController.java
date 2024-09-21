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

import com.project.school.management.request.IncomeRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.IncomeService;

@CrossOrigin
@RestController
@RequestMapping("income")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;
	
	@PostMapping("saveIncome")
	public ResponseEntity<Response> saveIncome(@RequestBody IncomeRequest incomeRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(incomeService.saveIncome(incomeRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getIncomeList")
	public ResponseEntity<Object> getIncomeList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(incomeService.getIncomeList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getIncomeById/{id}")
	public ResponseEntity<Object> getIncomeById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(incomeService.getIncomeById(id));
		return ResponseEntity.ok().body(response);
	}

}
