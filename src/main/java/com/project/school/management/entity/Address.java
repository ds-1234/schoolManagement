package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "street", nullable = false)
	private String street;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "state", nullable = false)
	private String state;

	@Column(name = "pinCode", nullable = false)
	private String pinCode;

	@Column(name = "country", nullable = false)
	private String country;

//	@OneToMany(mappedBy = "address")
//	private Set<UserEntity> user;

//	@OneToMany(mappedBy = "address")
//	private Set<School> school;

}
