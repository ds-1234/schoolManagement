package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name ="event_category")
public class EventCategoryEntity {
	
	@Id
	private Long id;
	
	@Column(name = "event_category_title")
	private String eventCategoryTitle;
	
	@Column(name = "event_category_id")
	private String eventCategoryId;
	
	@Column(name = "event_cat_color_code")
	private String eventCatColorCode;
	
	@Column(name = "status")
	private Boolean isActive;

}
