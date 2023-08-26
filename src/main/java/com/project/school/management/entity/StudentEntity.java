package com.project.school.management.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name="student_entity")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="student_id")
	private String studentId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="date_of_birth")
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date dateOfBirth;

	@Column(name="grade")
	private String grade;
	
	@Column(name="grade_section")
	private String gradeSection;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="parents_contact")
	private Long parentsContact;
	
	@Column(name="admission_id")
	private String admissionId;
	
	@Column(name="blood_group")
	private String bloodGroup;
	
	@Transient
	private List<RoleEntity> role;

}
