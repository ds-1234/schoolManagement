package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.AccountsExpenses;
import com.project.school.management.repository.AccountExpenseRepository;
import com.project.school.management.response.ResponseHandler;
import com.project.school.management.service.ManagementAccountsService;
import com.project.school.management.utility.Utils;

@Service
public class ManagementAccountsServiceImpl implements ManagementAccountsService{
	
	private static final Logger log = LoggerFactory.getLogger(ManagementAccountsServiceImpl.class);
	
	@Autowired
	private AccountExpenseRepository accountExpenseRepository;
	
	@Autowired
	private Utils utils;

	@Override
	public ResponseEntity<Object> addExpense(AccountsExpenses accountsRequest) throws IOException {
		log.info("++++inside add expense method+++");
		String accoundId = utils.generateUniqueId(accountsRequest.getItemName());
		String str = "AP" + accoundId;
		accountsRequest.setExpenseId(str);
		
		accountsRequest.setStatus(true);
		accountExpenseRepository.save(accountsRequest);
		log.info("++++Expenses added successfully+++");
		return ResponseHandler.generateResponse("SUCCESS:Expenses added successfully", HttpStatus.OK, "", accountsRequest);
	}

	@Override
	public ResponseEntity<Object> getExpense() throws IOException {
		log.info("++++inside get expense method+++");
		List<AccountsExpenses> accList = accountExpenseRepository.findAll();
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", accList);
	}

}
