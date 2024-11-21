package com.project.school.management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name ="chat_message")
public class ChatMessageEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    
    @ManyToOne
    private UserEntity sender;

    @ManyToOne
    private ChatRoomEntity chatRoom; // Nullable for direct messages

    @ManyToOne
    private UserEntity receiver; // Nullable for group messages

    private String messageText;
    private LocalDateTime timestamp;
    private String status; // "sent", "delivered", "read"

}
