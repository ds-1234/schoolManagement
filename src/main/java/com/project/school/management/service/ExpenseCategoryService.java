package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.MasterExpenseCategoryEntity;

public interface ExpenseCategoryService {

	MasterExpenseCategoryEntity save(MasterExpenseCategoryEntity expCatRequest);

	List<MasterExpenseCategoryEntity> getExpenseCatList();

	MasterExpenseCategoryEntity deleteExpenseCat(Long id);

	MasterExpenseCategoryEntity getExpenseCatById(Long id);

}
