package com.project.school.management.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "class")
public class ClassEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "section_id", referencedColumnName = "id")
//	Section section;

	@Column(name = "section", nullable = false)
	private String section;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToMany(fetch = FetchType.LAZY)
	List<Subject> subject = new ArrayList<>();
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToMany(fetch = FetchType.LAZY)
	List<UserEntity> userEntity = new ArrayList<>();

}
