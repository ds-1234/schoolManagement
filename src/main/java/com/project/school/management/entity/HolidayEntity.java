package com.project.school.management.entity;

import java.sql.Date;

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
@Table(name="holiday")
@Entity
public class HolidayEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "holiday_id", nullable = false)
	private String holidayId;
	
	@Column(name = "holiday_name", nullable = false)
	private String holidayName;
	
	@Column(name = "holiday_date", nullable = false)
	private Date holidayDate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status", nullable = false)
	private Boolean isActive;

}
