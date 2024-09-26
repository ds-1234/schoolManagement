package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.MasterExpenseCategoryEntity;
import com.project.school.management.exception.InvalidRequestException;
import com.project.school.management.repository.ExpenseCategoryRepository;
import com.project.school.management.service.ExpenseCategoryService;
import com.project.school.management.utility.Utils;
@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService{
	
	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	@Autowired
	private Utils utils;

	@Override
	public MasterExpenseCategoryEntity save(MasterExpenseCategoryEntity expCatRequest) {
		MasterExpenseCategoryEntity entity = new MasterExpenseCategoryEntity();
		if(Objects.isNull(expCatRequest.getId())) {
			String expCatId = "EC" + utils.generateRandomId();
			entity.setExpenseCategoryId(expCatId);
			
			String categoryName = utils.capitalizeFirstCharacter(expCatRequest.getExpenseCategoryName());
			entity.setExpenseCategoryName(categoryName);
			entity.setExpenseCategoryDescription(expCatRequest.getExpenseCategoryDescription());
			entity.setIsActive(expCatRequest.getIsActive());
			return this.expenseCategoryRepository.save(entity);
		}else {
			Optional<MasterExpenseCategoryEntity> dbData = this.expenseCategoryRepository.findById(expCatRequest.getId());
			if(dbData.isEmpty()) {
				throw new InvalidRequestException();
			}
			MasterExpenseCategoryEntity data = dbData.get();
			String categoryName = utils.capitalizeFirstCharacter(expCatRequest.getExpenseCategoryName());
			data.setExpenseCategoryId(data.getExpenseCategoryId());
			data.setExpenseCategoryName(categoryName);
			data.setExpenseCategoryDescription(expCatRequest.getExpenseCategoryDescription());
			data.setIsActive(expCatRequest.getIsActive());
			return this.expenseCategoryRepository.save(data);
		}
	}

	@Override
	public List<MasterExpenseCategoryEntity> getExpenseCatList() {
		return this.expenseCategoryRepository.findAll();
	}

	@Override
	public MasterExpenseCategoryEntity deleteExpenseCat(Long id) {
		MasterExpenseCategoryEntity entity = expenseCategoryRepository.findById(id)
				.orElseThrow(()-> new InvalidRequestException("given id is invalid"));
		
		expenseCategoryRepository.delete(entity);
		return entity;
	}

	@Override
	public MasterExpenseCategoryEntity getExpenseCatById(Long id) {
		MasterExpenseCategoryEntity entity = expenseCategoryRepository.findById(id)
				.orElseThrow(()-> new InvalidRequestException("given id is invalid"));
		return entity;
	}

}
