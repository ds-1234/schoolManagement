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
@Table(name="master_library")
public class MasterLibrary {
	
	@Id
	@Column(name="book_id")
	private String bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="book_language")
	private Integer bookLanguage;
	
	@Column(name="department")
	private Integer department;
	
	@Column(name="book_quantity")
	private Integer bookQuantity;
	
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
