package com.project.school.management.service;

import java.io.IOException;

import com.project.school.management.entity.EventEntity;
import com.project.school.management.request.EventRequest;

public interface EventService {

	EventEntity saveEvent(EventRequest eventRequest) throws IOException;

}
