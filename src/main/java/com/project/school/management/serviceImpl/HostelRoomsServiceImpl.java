package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.HostelRoomsEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.HostelRoomsRepository;
import com.project.school.management.request.HostelRoomsRequest;
import com.project.school.management.service.HostelRoomsService;
import com.project.school.management.utility.Utils;
@Service
public class HostelRoomsServiceImpl implements HostelRoomsService{
	
	@Autowired
	private HostelRoomsRepository hostelRoomsRepository;
	
	@Autowired
	private Utils utils;
	
	public HostelRoomsEntity saveHostelRooms(HostelRoomsRequest hostelRoomsRequest) {
		HostelRoomsEntity entity = new HostelRoomsEntity();
		if(Objects.isNull(hostelRoomsRequest.getId())) {
			String hostelRoomId = utils.generateRandomId();
			entity.setHostelRoomId("HR"+hostelRoomId);
			entity.setHostelRoomNumber(hostelRoomsRequest.getHostelRoomNumber());
			entity.setHostelName(hostelRoomsRequest.getHostelName());
			entity.setCostPerBed(hostelRoomsRequest.getCostPerBed());
			entity.setNumOfBeds(hostelRoomsRequest.getNumOfBeds());
			entity.setRoomType(hostelRoomsRequest.getRoomType());
			entity.setIsActive(hostelRoomsRequest.getIsActive());
			return hostelRoomsRepository.save(entity);
		}else {
			HostelRoomsEntity dbEntity = hostelRoomsRepository.findById(hostelRoomsRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given id is invalid"));
			dbEntity.setCostPerBed(hostelRoomsRequest.getCostPerBed());
			dbEntity.setHostelName(hostelRoomsRequest.getHostelName());
			dbEntity.setHostelRoomNumber(hostelRoomsRequest.getHostelRoomNumber());
			dbEntity.setIsActive(hostelRoomsRequest.getIsActive());
			dbEntity.setNumOfBeds(hostelRoomsRequest.getNumOfBeds());
			dbEntity.setRoomType(hostelRoomsRequest.getRoomType());
			return hostelRoomsRepository.save(dbEntity);
		}
	}

	@Override
	public List<HostelRoomsEntity> getHostelRoomsList() {
		return this.hostelRoomsRepository.findAll();
	}

	@Override
	public HostelRoomsEntity getHostelRoomsById(Long id) {
		HostelRoomsEntity dbEntity = hostelRoomsRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or empty"));
		return dbEntity;
	}

	@Override
	public Object deleteHostelRooms(Long id) {
		HostelRoomsEntity dbEntity = hostelRoomsRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or empty"));
		hostelRoomsRepository.delete(dbEntity);
		return "Room Number "+dbEntity.getHostelRoomNumber() + " from " +dbEntity.getHostelName().getHostelName()
				+" is deleted successfully";
	}

}
