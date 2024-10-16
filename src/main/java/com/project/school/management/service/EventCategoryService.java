package com.project.school.management.service;

import java.io.IOException;
import java.util.List;

import com.project.school.management.entity.EventCategoryEntity;
import com.project.school.management.request.EventCategoryRequest;

public interface EventCategoryService {

	EventCategoryEntity saveEventCategory(EventCategoryRequest eventCategoryRequest)throws IOException;

	List<EventCategoryEntity> getEventCatList();

	EventCategoryEntity getEventCatById(Long id);

}
