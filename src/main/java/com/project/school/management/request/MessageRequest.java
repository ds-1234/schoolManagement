package com.project.school.management.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class MessageRequest {
	
	Long receiverId;
	Long senderId;
	String messageText;
	LocalDateTime dateTime;
	String status;
	Long roomId;

}
