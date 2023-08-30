package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "school")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

//	@OneToMany(mappedBy = "school")
//	private Set<UserEntity> user;

	// @JsonIgnore
	@ManyToOne()
	private Address address;

}
