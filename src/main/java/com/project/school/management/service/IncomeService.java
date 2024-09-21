package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.IncomeEntity;
import com.project.school.management.request.IncomeRequest;

public interface IncomeService {

	IncomeEntity saveIncome(IncomeRequest incomeRequest);

	List<IncomeEntity> getIncomeList();

	IncomeEntity getIncomeById(Long id);

}
