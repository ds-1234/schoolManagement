package com.project.school.management.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class IncomeRequest {
	
	String incomeName;
	
	String incomeSource;
	
	LocalDate incomeDate;
	
	BigDecimal amount;
	
	String invoice;
	
	String paymentMode;
	
	String description;
	
	Boolean isActive;

}
