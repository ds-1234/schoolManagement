package com.project.school.management.service;

import com.project.school.management.request.MessageRequest;

public interface ChatService {

	Object sendMessage(MessageRequest messageRequest);

}
