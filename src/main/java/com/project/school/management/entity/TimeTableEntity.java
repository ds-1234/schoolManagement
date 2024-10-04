package com.project.school.management.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Data
@Table(name = "time_table")
public class TimeTableEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "className", nullable = false)
	private Long className;
	
	@Column(name = "userId", nullable = false)
	private Long userId;

	@Column(name = "weekDay", nullable = false)
    private String weekDay; // Instead of List<String>, now a single String

	@Column(name = "startTime", nullable = false)
    private LocalTime startTime;
   
	@Column(name = "endTime", nullable = false)
    private LocalTime endTime;

	@Column(name = "subject", nullable = false)
	private List<Long> subject = new ArrayList<>();
	
	@Column(name = "isActive", nullable = false)
	private Boolean isActive;
	
}
