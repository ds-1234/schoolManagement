package com.project.school.management.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "author", nullable = false)
	private String author;

	@Column(name = "publishingYear", nullable = false)
	private String publishingYear;

	@Column(name = "bookUniqueId")
	private String bookUniqueId;

	@Column(name = "bookRefId")
	private String bookRefId;

	@Column(name = "allotedStratDate")
	private Date allotedStratDate;

	@Column(name = "allotedEndtDate")
	private Date allotedEndtDate;

	@Column(name = "isActive")
	private Boolean isActive;

	@JsonBackReference
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user;

}
