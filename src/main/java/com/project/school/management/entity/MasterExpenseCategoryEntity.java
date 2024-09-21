package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "master_expense_category")
public class MasterExpenseCategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "expense_category_id", nullable = false)
	private String expenseCategoryId;
	
	@Column(name = "expense_category_name", nullable = false)
	private String expenseCategoryName;
	
	@Column(name = "expense_category_description")
	private String expenseCategoryDescription;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;

}
