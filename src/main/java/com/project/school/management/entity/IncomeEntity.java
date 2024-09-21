package com.project.school.management.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "incomes")
public class IncomeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "income_id", nullable = false)
	private String incomeId;
	
	@Column(name = "income_name", nullable = false)
	private String incomeName;
	
	@Column(name = "income_source", nullable = false)
	private String incomeSource;
	
	@Column(name = "income_date", nullable = false)
	private LocalDate incomeDate;
	
	@Column(name = "amount", nullable = false)
	private BigDecimal amount;
	
	@Column(name = "invoice")
	private String invoice;
	
	@Column(name = "payment_mode", nullable = false)
	private String paymentMode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;

}
