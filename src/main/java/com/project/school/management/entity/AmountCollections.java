package com.project.school.management.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity(name="amount_collection")
public class AmountCollections {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "amount", nullable = false)
	private BigDecimal amount;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	

}
