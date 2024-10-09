package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "fees_group")
public class FeesGroupEntity {
	
	@Id
	private Long id;
	
	@Column(name ="fees_group_id", nullable = false)
	private String feesGroupId;
	
	@Column(name ="fees_group_name", nullable = false)
	private String feesGroupName;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="status", nullable = false)
	private Boolean isActive;

}
