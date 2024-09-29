package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "room_type")
public class RoomTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_type_id", nullable = false)
	private String roomTypeId;
	
	@Column(name = "room_type_name", nullable = false)
	private String roomTypeName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;

}
