package com.project.school.management.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "expenses")
public class ExpenseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "expense_id", nullable = false)
	private String expenseId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_expense_category_id")
	//@Column(name = "expense_type", nullable = false)
	private MasterExpenseCategoryEntity expenseType;
	
	@Column(name = "amount", nullable = false)
	private BigDecimal amount;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "payment_mode", nullable = false)
	private String payment_mode;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;

}
