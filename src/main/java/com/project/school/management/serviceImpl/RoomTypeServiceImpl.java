package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.RoomTypeEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.RoomTypeRepository;
import com.project.school.management.request.RoomTypeRequest;
import com.project.school.management.service.RoomTypeService;
import com.project.school.management.utility.Utils;
@Service
public class RoomTypeServiceImpl implements RoomTypeService{
	
	@Autowired
	private RoomTypeRepository roomTypeRepository;
	
	@Autowired
	private Utils utils;

	@Override
	public RoomTypeEntity saveRoomType(RoomTypeRequest roomTypeRequest) {
		RoomTypeEntity entity = new RoomTypeEntity();
		if(Objects.isNull(roomTypeRequest.getId())) {
			String roomTypeId = utils.generateRandomId();
			entity.setRoomTypeId("RT"+roomTypeId);
			
			String roomTypeName = utils.capitalizeFirstCharacter(roomTypeRequest.getRoomTypeName());
			entity.setRoomTypeName(roomTypeName);
			
			entity.setDescription(roomTypeRequest.getDescription());
			entity.setIsActive(roomTypeRequest.getIsActive());
			return roomTypeRepository.save(entity);
		}else {
			RoomTypeEntity dbData = roomTypeRepository.findById(roomTypeRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid"));
			String roomTypeName = utils.capitalizeFirstCharacter(roomTypeRequest.getRoomTypeName());
			dbData.setRoomTypeName(roomTypeName);
			
			dbData.setDescription(roomTypeRequest.getDescription());
			dbData.setIsActive(roomTypeRequest.getIsActive());
			return roomTypeRepository.save(dbData);
		}
	}

	@Override
	public List<RoomTypeEntity> getRoomTypeList() {
		return this.roomTypeRepository.findAll();
	}

	@Override
	public RoomTypeEntity getRoomTypeById(Long id) {
		RoomTypeEntity dbData = roomTypeRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid or empty"));
		return dbData;
	}

	@Override
	public Object deleteRoomType(Long id) {
		RoomTypeEntity dbData = roomTypeRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid or empty"));
		roomTypeRepository.delete(dbData);
		return dbData.getRoomTypeName() + " is deleted successfully";
	}

}
