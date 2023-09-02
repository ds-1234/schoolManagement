package com.project.school.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.school.management.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_entity")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Column(name = "fatherName", nullable = false)
	private String fatherName;

	@Column(name = "motherName", nullable = false)
	private String motherName;

	@Column(name = "gender", nullable = false)
	private Gender gender;

	@Column(name = "dateOfBirth", nullable = false)
	private Date dateOfBirth;

	@Column(name = "houseNumber", nullable = false)
	private String houseNumber;

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

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	private ClassEntity className;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	private Role role;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "userId", nullable = false)
	private String userId;

	@Column(name = "is_parent", nullable = true)
	private List<String> isParent;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	private School school;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Book> book = new ArrayList<>();

	@Column(name = "isActive", nullable = false)
	private Boolean isActive;

}
