package com.project.school.management.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.AccountsExpenses;
import com.project.school.management.entity.HolidayEntity;
import com.project.school.management.service.ManagementAccountsService;

@RestController
@RequestMapping("/accounts")
public class ManagementAccountController {
	
	private static final Logger log = LoggerFactory.getLogger(ManagementAccountController.class);
	
	@Autowired
	private ManagementAccountsService managementAccountsService;
	
	
	@PostMapping("/addExpense")
	public ResponseEntity<Object> addExpense(@RequestBody AccountsExpenses accountsRequest) throws IOException{
		log.info("******API Start For save expense******");
				return managementAccountsService.addExpense(accountsRequest);	
	}
	
	@GetMapping("/getExpense")
	public ResponseEntity<Object> getExpense() throws IOException{
		log.info("******API Start For get expense******");
				return managementAccountsService.getExpense();	
	}

}
