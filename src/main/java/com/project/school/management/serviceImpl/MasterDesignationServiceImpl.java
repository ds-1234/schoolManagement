package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.MasterDesignationEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.MasterDesignationRepository;
import com.project.school.management.request.DesignationRequest;
import com.project.school.management.service.MasterDesignationService;
import com.project.school.management.utility.Utils;
@Service
public class MasterDesignationServiceImpl implements MasterDesignationService{
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private MasterDesignationRepository masterDesignationRepository;

	@Override
	public MasterDesignationEntity saveDesignation(DesignationRequest designationRequest) {
		MasterDesignationEntity entity = new MasterDesignationEntity();
		if(Objects.isNull(designationRequest.getId())) {
			String designationId = utils.generateRandomId();
			entity.setDesignationId("DS"+designationId);
			entity.setDesignationName(designationRequest.getDesignationName().toUpperCase());
			entity.setIsActive(designationRequest.getIsActive());
			return masterDesignationRepository.save(entity);
		}else {
			MasterDesignationEntity dbDesignationEntity = masterDesignationRepository.findById(designationRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given id is invalid"));
			dbDesignationEntity.setDesignationName(designationRequest.getDesignationName().toUpperCase());
			dbDesignationEntity.setIsActive(designationRequest.getIsActive());
			return masterDesignationRepository.save(dbDesignationEntity);
					
		}
	}

	@Override
	public List<MasterDesignationEntity> getDesignationList() {
		return masterDesignationRepository.findAll();
	}

	@Override
	public MasterDesignationEntity getDesignationById(Long id) {
		MasterDesignationEntity dbDesignationEntity = masterDesignationRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or empty"));
		return dbDesignationEntity;
	}

	@Override
	public Object deleteDesignation(Long id) {
		MasterDesignationEntity dbDesignationEntity = masterDesignationRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or empty"));
		masterDesignationRepository.delete(dbDesignationEntity);
		return dbDesignationEntity.getDesignationName()+ " is deleted successfully.";
	}

}
