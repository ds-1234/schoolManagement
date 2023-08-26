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
@Table(name="master_holiday")
public class MasterHoliday {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="holiday_assign_id")
	private String holidayAssignId;
	
	@Column(name="master_holiday_name", nullable = false)
	private String masterHolidayName;
	
	@Column(name="description", nullable = false)
	private String description;
	
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
