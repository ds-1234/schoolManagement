package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.RoomTypeEntity;
import com.project.school.management.request.RoomTypeRequest;

public interface RoomTypeService {

	RoomTypeEntity saveRoomType(RoomTypeRequest roomTypeRequest);

	List<RoomTypeEntity> getRoomTypeList();

	RoomTypeEntity getRoomTypeById(Long id);

	Object deleteRoomType(Long id);

}
