package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.entity.EventCategoryEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.EventCategoryRepository;
import com.project.school.management.request.EventCategoryRequest;
import com.project.school.management.service.EventCategoryService;
import com.project.school.management.utility.Utils;

@Service
public class EventCategoryServiceImpl implements EventCategoryService {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private Utils utils;

	@Autowired
	private EventCategoryRepository eventCategoryRepository;

	public EventCategoryServiceImpl(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public List<EventCategoryEntity> getEventCatList() {
		return this.eventCategoryRepository.findAll();
	}

	@Override
	public EventCategoryEntity getEventCatById(Long id) {
		EventCategoryEntity dbData = eventCategoryRepository.findById(id)
				.orElseThrow(() -> new InvalidArgumentException("given id is invalid"));
		return dbData;
	}

	@Override
	public EventCategoryEntity saveEventCategory(EventCategoryRequest eventCategoryRequest) throws IOException {
		if (Objects.isNull(eventCategoryRequest.getId())) {
			EventCategoryEntity entity = objectMapper.convertValue(eventCategoryRequest, EventCategoryEntity.class);
			Long lastId = eventCategoryRepository.findMaxId();
			long newId = (lastId == null || lastId == 0) ? 1 : lastId + 1;
			entity.setId(newId);
			String eventCatId = utils.generateRandomId();
			entity.setEventCategoryId("EC" + eventCatId);
			return eventCategoryRepository.save(entity);
		} else {
			EventCategoryEntity dbData = eventCategoryRepository.findById(eventCategoryRequest.getId())
					.orElseThrow(() -> new InvalidArgumentException("given id is invalid"));
			objectMapper.updateValue(dbData, eventCategoryRequest);
			return eventCategoryRepository.save(dbData);

		}
	}

}
