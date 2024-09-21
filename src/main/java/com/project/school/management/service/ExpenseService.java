package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.ExpenseEntity;
import com.project.school.management.request.ExpenseRequest;

public interface ExpenseService {

	ExpenseEntity saveExpenses(ExpenseRequest expenseRequest);

	List<ExpenseEntity> getExpensesList();

	ExpenseEntity getExpensesById(Long id);

}
