package com.project.school.management.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.project.school.management.entity.MasterExpenseCategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ExpenseRequest {
	
	String name;
	
	MasterExpenseCategoryEntity expenseType;
	
	BigDecimal amount;
	
	String paymentMode;
	
	LocalDate date;
	
	String phoneNumber;
	
	String email;
	
	Boolean isActive;

}
