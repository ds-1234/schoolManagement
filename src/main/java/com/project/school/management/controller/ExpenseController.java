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

import com.project.school.management.request.ExpenseRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.ExpenseService;

@CrossOrigin
@RestController
@RequestMapping("expenses")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping("createExpenses")
	public ResponseEntity<Response> createExpenses(@RequestBody ExpenseRequest expenseRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(expenseService.saveExpenses(expenseRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExpensesList")
	public ResponseEntity<Object> getExpensesList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(expenseService.getExpensesList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExpensesById/{id}")
	public ResponseEntity<Object> getExpensesById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(expenseService.getExpensesById(id));
		return ResponseEntity.ok().body(response);
	}

}
