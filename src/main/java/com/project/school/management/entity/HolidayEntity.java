package com.project.school.management.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="holiday_entity")
public class HolidayEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="holiday_id")
	private String holidayId;
	
	@Column(name="holiday_name")
	private String holidayName;
	
	@Column(name="holiday_type")
	private Integer holidayType;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(name="end_date")
	private Date endDate;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-mm-yyyy hh:mm")
	@Column(name = "cratedon")
	private Date cratedon;

	@PrePersist
	protected void onCreate() {
		cratedon = new Date();
	}
	
	@Column(name="status")
	private boolean status;

}
