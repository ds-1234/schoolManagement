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

import com.project.school.management.entity.MasterExpenseCategoryEntity;
import com.project.school.management.response.Response;
import com.project.school.management.service.ExpenseCategoryService;

@CrossOrigin
@RestController
@RequestMapping("expenseCat")
public class ExpenseCategoryController {
	
	@Autowired
	private ExpenseCategoryService expenseCategoryService;
	
	@PostMapping("saveExpenseCat")
	public ResponseEntity<Response> createExpenseCat(@RequestBody MasterExpenseCategoryEntity expCatRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(expenseCategoryService.save(expCatRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExpenseCatList")
	public ResponseEntity<Object> getExpenseCatList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(expenseCategoryService.getExpenseCatList());
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteExpenseCat/{id}")
	public ResponseEntity<Response> deleteExpenseCat(@PathVariable Long id) {
		MasterExpenseCategoryEntity entity = expenseCategoryService.deleteExpenseCat(id);
		Response response = new Response();
		response.succeed();
		response.setMessage(entity.getExpenseCategoryName() + " category deleted successfully");
		response.setData(entity);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExpenseCatById/{id}")
	public ResponseEntity<Object> getExpenseCatById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(expenseCategoryService.getExpenseCatById(id));
		return ResponseEntity.ok().body(response);
	}

}
