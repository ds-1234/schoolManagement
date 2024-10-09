package com.project.school.management.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "fees_collection")
public class FeesCollectionEntity {
	
	@Id
	private Long id;
	
	@Column(name ="user_id", nullable = false)
	private Long userId;
	
	@Column(name ="fees_collection_id", nullable = false)
	private String feesCollectionId;
	
	@Column(name ="fees_group_name_id", nullable = false)
	private Long feesGroupNameId;
	
	@Column(name ="fee_amount", nullable = false)
	private BigDecimal feeAmount;
	
	@Column(name ="collection_date")
	private LocalDate collectionDate;
	
	@Column(name ="payment_type", nullable = false)
	private String paymentType;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="status", nullable = false)
	private Boolean isActive;

}
