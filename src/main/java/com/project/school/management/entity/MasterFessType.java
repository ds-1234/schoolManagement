package com.project.school.management.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//@Data
//@Entity
//@Table(name="master_fees_type")
public class MasterFessType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="fees_assign_id")
	private String feesAssignId;
	
	@Column(name="fees_type", nullable = false)
	private String feesType;
	
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
