package com.project.school.management.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.project.school.management.entity.AccountsExpenses;

public interface ManagementAccountsService {

	ResponseEntity<Object> addExpense(AccountsExpenses accountsRequest) throws IOException;

	ResponseEntity<Object> getExpense() throws IOException;

}
