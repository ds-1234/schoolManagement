package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		if(Objects.isNull(eventRequest.getEventTitle()) || Objects.isNull(eventRequest.getEventCategory())) {
			throw new InvalidArgumentException("Event title or Event Category is empty");
		}
		if(Objects.isNull(eventRequest.getStartDate()) || Objects.isNull(eventRequest.getEndDate())
				|| Objects.isNull(eventRequest.getStartTime()) || Objects.isNull(eventRequest.getEndTime())) {
			throw new InvalidArgumentException("Event Date or Time is empty");
		}
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

	@Override
	public List<EventEntity> getEventList() {
		return eventRepository.findAll();
	}

	@Override
	public EventEntity getEventById(Long id) {
		EventEntity dbData = eventRepository.findById(id)
				.orElseThrow(() -> new InvalidArgumentException("given id is invalid"));
		return dbData;
	}

	@Override
	public Object deleteEvent(Long id) {
		EventEntity dbData = eventRepository.findById(id)
				.orElseThrow(() -> new InvalidArgumentException("given id is invalid"));
		eventRepository.delete(dbData);
		return dbData.getEventTitle()+ " is deleted successfully";
	}

	@Override
	public List<EventEntity> getEventListByCatId(Long catId) {
		List<EventEntity> list = eventRepository.findByCatId(catId);
		return list;
	}

	@Override
	public List<EventEntity> getEventByCalandarType(String type, LocalDate date, Integer month,
			Integer year, String dateRange) {
		List<EventEntity> result = new ArrayList<>();
		if ("month".equalsIgnoreCase(type) && month != null && year != null) {
			result = eventRepository.findByMonthAndYear(month, year);
		} else if ("week".equalsIgnoreCase(type) && dateRange != null) {
			String[] dates = dateRange.split(" : ");

			// Output the results
			String startDate = dates[0].trim();
			String endDate = dates[1].trim();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate stDate = LocalDate.parse(startDate, formatter);
			LocalDate enDate = LocalDate.parse(endDate, formatter);
			result = eventRepository.findByWeek(stDate, enDate);
		} else if ("date".equalsIgnoreCase(type) && date != null) {
			result = eventRepository.findByDate(date);
		}

		return result;
	}

}
