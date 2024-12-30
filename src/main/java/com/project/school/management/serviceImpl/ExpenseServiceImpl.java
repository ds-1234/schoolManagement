package com.project.school.management.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.AmountCollections;
import com.project.school.management.entity.ExpenseEntity;
import com.project.school.management.exception.InvalidRequestException;
import com.project.school.management.repository.ExpenseRepository;
import com.project.school.management.request.ExpenseRequest;
import com.project.school.management.service.ExpenseService;
import com.project.school.management.utility.Utils;

@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public ExpenseEntity saveExpenses(ExpenseRequest expenseRequest) {
		ExpenseEntity entity = new ExpenseEntity();
		String expenseId = utils.generateRandomId();
		entity.setExpenseId("EX" +expenseId);
		entity.setName(expenseRequest.getName());
		entity.setExpenseType(expenseRequest.getExpenseType());
		entity.setAmount(expenseRequest.getAmount());
		Boolean validPhone = utils.isValidPhoneNumber(expenseRequest.getPhoneNumber());
		if(validPhone.FALSE) {
			throw new InvalidRequestException("Phone number is invalid or empty");
		}
		entity.setPhoneNumber(expenseRequest.getPhoneNumber());
		
		Boolean validEmail = utils.isValidEmail(expenseRequest.getEmail());
		if(validEmail.FALSE) {
			throw new InvalidRequestException("email id is invalid or empty");
		}
		entity.setEmail(expenseRequest.getEmail());
		entity.setPayment_mode(expenseRequest.getPaymentMode());
		entity.setDate(expenseRequest.getDate());
		entity.setIsActive(expenseRequest.getIsActive());
		expenseRepository.save(entity);
		AmountCollections amount = new AmountCollections();
		amount.setAmount(expenseRequest.getAmount());
		amount.setDate(expenseRequest.getDate());
		amount.setType("EXPENSE");
		return entity;
	}

	@Override
	public List<ExpenseEntity> getExpensesList() {
		List<ExpenseEntity> list = expenseRepository.findAll();
		list.sort(Comparator.comparing(ExpenseEntity::getDate).reversed());
		return list;
	}

	@Override
	public ExpenseEntity getExpensesById(Long id) {
		Optional<ExpenseEntity> dbData = expenseRepository.findById(id);
		if(dbData.isEmpty()) {
			throw new InvalidRequestException("given id is invalid or not present");
		}
		return dbData.get();
	}

}
