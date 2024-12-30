package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.entity.AmountCollections;
import com.project.school.management.entity.FeesCollectionEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.AmountCollectionRepository;
import com.project.school.management.repository.FeesCollectionRepository;
import com.project.school.management.request.FeesCollectionRequest;
import com.project.school.management.service.FeesCollectionService;
import com.project.school.management.utility.Utils;

@Service
public class FeesCollectionServiceImpl implements FeesCollectionService {
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private FeesCollectionRepository feesCollectionRepository;
	
	@Autowired
	private AmountCollectionRepository amountCollectionRepository;

	@Autowired
	private ObjectMapper objectMapper;

	public FeesCollectionServiceImpl(ObjectMapper objectMapper) {
	        this.objectMapper = objectMapper;
	    }

	@Override
	public FeesCollectionEntity savefeesCollection(FeesCollectionRequest feesCollectionRequest) throws IOException {
		if (Objects.isNull(feesCollectionRequest.getId())) {
			FeesCollectionEntity entity = objectMapper.convertValue(feesCollectionRequest, FeesCollectionEntity.class);
			Long lastId = feesCollectionRepository.findMaxId();
			long newId = (lastId == null || lastId == 0) ? 1 : lastId + 1;
			entity.setId(newId);
			String feesCollectionId = utils.generateRandomId();
			entity.setFeesCollectionId("FC"+feesCollectionId);
			entity.setCollectionDate(LocalDate.now());
			feesCollectionRepository.save(entity);
			AmountCollections incomeCollection = new AmountCollections();
			incomeCollection.setAmount(feesCollectionRequest.getFeeAmount());
			incomeCollection.setDate(LocalDate.now());
			incomeCollection.setType("INCOME");
			if(feesCollectionRequest.getIsActive()==true) {
				amountCollectionRepository.save(incomeCollection);
			}
			return entity;
		} else {
			FeesCollectionEntity dbData = feesCollectionRepository.findById(feesCollectionRequest.getId())
					.orElseThrow(() -> new InvalidArgumentException("given id is invalid"));
			objectMapper.updateValue(dbData, feesCollectionRequest);
			feesCollectionRepository.save(dbData);
			AmountCollections incomeCollection = new AmountCollections();
			incomeCollection.setAmount(feesCollectionRequest.getFeeAmount());
			incomeCollection.setDate(LocalDate.now());
			incomeCollection.setType("INCOME");
			if(feesCollectionRequest.getIsActive()==true) {
				amountCollectionRepository.save(incomeCollection);
			}
			return dbData;

		}
	}

	@Override
	public List<FeesCollectionEntity> getFeesCollectionList() {
		return feesCollectionRepository.findAll();
	}

	@Override
	public FeesCollectionEntity getFeesCollectionById(Long id) {
		FeesCollectionEntity dbData = feesCollectionRepository.findById(id)
				.orElseThrow(() -> new InvalidArgumentException("given id is invalid"));
		return dbData;
	}

}
