package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Table(name ="leave_entity")
@Entity
public class LeaveEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "leave_id", nullable = false)
	private String leaveId;
	
	@Column(name = "leave_type", nullable = false)
	private String leaveType;
	
	@Column(name = "leave_description")
	private String leaveDescription;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;

}
