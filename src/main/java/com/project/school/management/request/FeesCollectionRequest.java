package com.project.school.management.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FeesCollectionRequest {

	Long id;
	Long feesGroupNameId;
	BigDecimal feeAmount;
	String paymentType;
	String description;
	Boolean isActive;

}
