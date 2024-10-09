package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.entity.FeesGroupEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.FeesGroupRepository;
import com.project.school.management.request.FeesGroupRequest;
import com.project.school.management.service.FeesGroupService;
import com.project.school.management.utility.Utils;
@Service
public class FeesGroupServiceImpl implements FeesGroupService{
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private FeesGroupRepository feesGroupRepository; 
	
	 public FeesGroupServiceImpl(ObjectMapper objectMapper) {
	        this.objectMapper = objectMapper;
	    }

	@Override
	public FeesGroupEntity saveFeesGroup(FeesGroupRequest feesGroupRequest) throws IOException{
		if(Objects.isNull(feesGroupRequest.getId())) {
			FeesGroupEntity entity = objectMapper.convertValue(feesGroupRequest, FeesGroupEntity.class);
			Long lastId = feesGroupRepository.findMaxId();
			long newId = (lastId == null || lastId == 0) ? 1 : lastId + 1;
			entity.setId(newId);
			String feesGroupId = utils.generateRandomId();
			entity.setFeesGroupId("FG"+feesGroupId);
			feesGroupRepository.save(entity);
			return entity;
		}else {
			FeesGroupEntity dbData= feesGroupRepository.findById(feesGroupRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("given id is invalid"));
			objectMapper.updateValue(dbData, feesGroupRequest);
			feesGroupRepository.save(dbData);
			return dbData;
			
		}
	}

	@Override
	public List<FeesGroupEntity> getFeesGroupList() {
		return this.feesGroupRepository.findAll();
	}

	@Override
	public FeesGroupEntity getFeesGroupById(Long id) {
		FeesGroupEntity dbData= feesGroupRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("given id is invalid"));
		return dbData;
	}

}
