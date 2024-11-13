package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "states")
public class StateEntity {

	@Id
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "country_id")
	private Long countryId;
}
