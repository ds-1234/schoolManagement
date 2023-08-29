package com.project.school.management.entity;

import java.util.Date;

import com.project.school.management.enums.Gender;
import com.project.school.management.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_entity")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

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

	@Column(name = "role", nullable = false)
	private Role role;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone", nullable = true)
	private Long phone;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "user_name", nullable = true)
	private String userName;

}
