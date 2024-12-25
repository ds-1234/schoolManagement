package com.project.school.management.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.AmountCollections;
import com.project.school.management.entity.IncomeEntity;
import com.project.school.management.exception.InvalidRequestException;
import com.project.school.management.repository.AmountCollectionRepository;
import com.project.school.management.repository.IncomeRepository;
import com.project.school.management.request.IncomeRequest;
import com.project.school.management.service.IncomeService;
import com.project.school.management.utility.Utils;
@Service
public class IncomeServiceImpl implements IncomeService{
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private AmountCollectionRepository amountCollectionRepository;
	
	@Autowired
	private Utils utils;

	@Override
	public IncomeEntity saveIncome(IncomeRequest incomeRequest) {
		IncomeEntity entity = new IncomeEntity();
		String generatedIncomeId = utils.generateRandomId();
		String incomeId = "IN" +generatedIncomeId;
		entity.setIncomeId(incomeId);
		
		String incomeName = utils.capitalizeFirstCharacter(incomeRequest.getIncomeName());
		entity.setIncomeName(incomeName);
		
		String incomeSource = utils.capitalizeFirstCharacter(incomeRequest.getIncomeSource());
		entity.setIncomeSource(incomeSource);
		entity.setIncomeDate(incomeRequest.getIncomeDate());
		entity.setAmount(incomeRequest.getAmount());
		
		String invoice = utils.upperCase(incomeRequest.getInvoice());
		entity.setInvoice(invoice);
		
		String paymentMode = utils.capitalizeFirstCharacter(incomeRequest.getPaymentMode());
		entity.setPaymentMode(paymentMode);
		entity.setDescription(incomeRequest.getDescription());
		entity.setIsActive(incomeRequest.getIsActive());
		incomeRepository.save(entity);
		AmountCollections incomeCollection = new AmountCollections();
		incomeCollection.setAmount(incomeRequest.getAmount());
		incomeCollection.setDate(incomeRequest.getIncomeDate());
		incomeCollection.setType("INCOME");
		amountCollectionRepository.save(incomeCollection);
		return entity;
	}

	@Override
	public List<IncomeEntity> getIncomeList() {
		List<IncomeEntity> incomeList = incomeRepository.findAll();
		incomeList.sort(Comparator.comparing(IncomeEntity::getIncomeDate).reversed());
		return incomeList;
	}

	@Override
	public IncomeEntity getIncomeById(Long id) {
		Optional<IncomeEntity> dbData = incomeRepository.findById(id);
		if(dbData.isEmpty()) {
			throw new InvalidRequestException("given id is invalid or empty");
		}
		return dbData.get();
	}

}
