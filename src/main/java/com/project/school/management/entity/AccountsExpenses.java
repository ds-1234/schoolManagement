package com.project.school.management.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="expenses")
public class AccountsExpenses {
	
	@Id
	@Column(name="expense_id")
	private String expenseId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_quantity")
	private Integer itemQuantity;
	
	@Column(name="amount")
	private Long amount;
	
	@Column(name="purchase_source")
	private String purchaseSource;
	
	@Column(name="purchase_by")
	private String purchaseBy;
	
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(name="purchase_date")
	private Date purchaseDate;
	
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
