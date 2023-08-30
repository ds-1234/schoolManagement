package com.project.school.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;

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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id", referencedColumnName = "id")
	private List<ClassEntity> className = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "section_id", referencedColumnName = "id")
	private List<Section> section = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	private School school;

	@Column(name = "isActive", nullable = false)
	private Boolean isActive;

}
