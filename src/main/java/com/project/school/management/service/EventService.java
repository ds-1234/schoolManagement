package com.project.school.management.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.project.school.management.entity.EventEntity;
import com.project.school.management.request.EventRequest;

public interface EventService {

	EventEntity saveEvent(EventRequest eventRequest) throws IOException;

	List<EventEntity> getEventList();

	EventEntity getEventById(Long id);

	Object deleteEvent(Long id);

	List<EventEntity> getEventListByCatId(Long catId);

	List<EventEntity> getEventByCalandarType(String type, LocalDate date, Integer month, Integer week, String dateRange);

}
