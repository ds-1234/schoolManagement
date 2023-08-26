package com.project.school.management.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="master_sports")
public class MasterSports {
	
	@Id
	@Column(name="sports_id")
	private String sportsId;
	
	@Column(name="sports_name")
	private String sportsName;
	
	@Column(name="coach_name")
	private String coachName;
	
	@Column(name="started_year")
	private Integer startedYear;
	
	@Column(name = "created_on_date_time")
	private Date createdOnDateTime;
	
	@Column(name = "updated_on_date_time")
	private Date updatedOnDateTime;
	
	@Column(name="status")
	private boolean status;

}
