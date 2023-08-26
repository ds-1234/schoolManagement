package com.project.school.management.entity;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="event_entity")
public class EventEntity {
	
	@Id
	@Column(name="event_id")
	private String eventId;
	
	@Column(name = "event_name")
	private String eventName;
	
	@Column(name = "desription")
	private String desription;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(name="end_date")
	private Date endDate;
	
//	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm")
	@Column(name="start_time")
	private Time startTime;
	
//	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm")
	@Column(name="end_time")
	private Time endTime;
	
	@Column(name="status")
	private boolean status;

	
}
