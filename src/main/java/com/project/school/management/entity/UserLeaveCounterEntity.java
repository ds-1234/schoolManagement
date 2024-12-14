package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "leave_counter_entity")
public class UserLeaveCounterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "leave_types")
	private Long leaveTypes;
	
	@Column(name = "leave_count")
	private Long leaveCount;
	
	@Column(name = "staff_id")
	private Long staffId;

}
