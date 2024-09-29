package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.HostelRoomsEntity;
import com.project.school.management.request.HostelRoomsRequest;

public interface HostelRoomsService {

	HostelRoomsEntity saveHostelRooms(HostelRoomsRequest hostelRoomsRequest);

	List<HostelRoomsEntity> getHostelRoomsList();

	HostelRoomsEntity getHostelRoomsById(Long id);

	Object deleteHostelRooms(Long id);

}
