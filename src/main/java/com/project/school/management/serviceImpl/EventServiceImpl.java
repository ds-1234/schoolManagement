package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.entity.EventCategoryEntity;
import com.project.school.management.entity.EventEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.EventRepository;
import com.project.school.management.request.EventRequest;
import com.project.school.management.service.EventService;
import com.project.school.management.utility.Utils;
@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private Utils utils;
	
	public EventServiceImpl(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public EventEntity saveEvent(EventRequest eventRequest) throws IOException {
		if (Objects.isNull(eventRequest.getId())) {
			EventEntity entity = objectMapper.convertValue(eventRequest, EventEntity.class);
			Long lastId = eventRepository.findMaxId();
			long newId = (lastId == null || lastId == 0) ? 1 : lastId + 1;
			entity.setId(newId);
			return eventRepository.save(entity);
		} else {
			EventEntity dbData = eventRepository.findById(eventRequest.getId())
					.orElseThrow(() -> new InvalidArgumentException("given id is invalid"));
			objectMapper.updateValue(dbData, eventRequest);
			return eventRepository.save(dbData);

		}
	}

}
