package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.HostelEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.HostelRepository;
import com.project.school.management.request.HostelRequest;
import com.project.school.management.service.HostelService;
import com.project.school.management.utility.Utils;
@Service
public class HostelServiceImpl implements HostelService{
	
	@Autowired
	private HostelRepository hostelRepository;
	
	@Autowired
	private Utils utils;

	@Override
	public HostelEntity saveHostel(HostelRequest hostelRequest) {
		HostelEntity entity = new HostelEntity();
		if(Objects.isNull(hostelRequest.getId())) {
			String hostelId = utils.generateRandomId();
			entity.setHostelId("HS"+hostelId);
			entity.setHostelType(hostelRequest.getHostelType());
			
			String hostelName = utils.capitalizeFirstCharacter(hostelRequest.getHostelName());
			entity.setHostelName(hostelName);
			entity.setHostelAddress(hostelRequest.getHostelAddress());
			entity.setIntakeBedCount(hostelRequest.getIntakeBedCount());
			entity.setDescription(hostelRequest.getDescription());
			entity.setIsActive(hostelRequest.getIsActive());
			return hostelRepository.save(entity);
		}else {
			HostelEntity dbDaEntity = hostelRepository.findById(hostelRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid"));
			dbDaEntity.setHostelType(hostelRequest.getHostelType());
			
			String hostelName = utils.capitalizeFirstCharacter(hostelRequest.getHostelName());
			dbDaEntity.setHostelName(hostelName);
			dbDaEntity.setHostelAddress(hostelRequest.getHostelAddress());
			dbDaEntity.setIntakeBedCount(hostelRequest.getIntakeBedCount());
			dbDaEntity.setDescription(hostelRequest.getDescription());
			dbDaEntity.setIsActive(hostelRequest.getIsActive());
			return hostelRepository.save(dbDaEntity);
		}
	}

	@Override
	public List<HostelEntity> getHostelList() {
		return this.hostelRepository.findAll();
	}

	@Override
	public HostelEntity getHostelById(Long id) {
		HostelEntity dbDaEntity = hostelRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid or empty"));
		return dbDaEntity;
	}

	@Override
	public Object deleteHostel(Long id) {
		HostelEntity dbDaEntity = hostelRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid or empty"));
		hostelRepository.delete(dbDaEntity);
		return dbDaEntity.getHostelName()+" is deleted successfully";
	}

}
