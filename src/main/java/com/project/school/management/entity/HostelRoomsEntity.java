package com.project.school.management.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "hostel_rooms")
public class HostelRoomsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "hostel_room_id", nullable = false)
	private String hostelRoomId;
	
	@Column(name = "hostel_room_number", nullable = false)
	private String hostelRoomNumber;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	private HostelEntity hostelName;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	private RoomTypeEntity roomType;
	
	@Column(name = "num_of_beds", nullable = false)
	private Long numOfBeds;
	
	@Column(name = "cost_per_bed")
	private BigDecimal costPerBed;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;
	
	

}
