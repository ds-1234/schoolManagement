package com.project.school.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.school.management.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_entity")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "fatherName")
	private String fatherName;

	@Column(name = "motherName")
	private String motherName;

	@Column(name = "gender")
	private Gender gender;

	@Column(name = "dateOfBirth")
	private Date dateOfBirth;

	@Column(name = "houseNumber")
	private String houseNumber;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "pinCode")
	private String pinCode;

	@Column(name = "country")
	private String country;

	@Column(name = "className")
	private List<Long> className = new ArrayList<>();

	
	@Column(name = "role")
	private Long role;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "password")
	private String password;

	@Column(name = "userName")
	private String userName;

	@Column(name = "userId")
	private String userId;

	@Column(name = "is_parent")
	private List<Long> isParent;

	@Column(name = "school")
	private Long school;

	@Column(name = "book")
	private List<Long> book = new ArrayList<>();
	
	@Column(name = "timeTable")
	private List<Long> timeTableEntity = new ArrayList<>();

	@Column(name = "isActive")
	private Boolean isActive;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Column(name = "relegion")
	private String relegion;
	
	@Column(name = "caste_category")
	private String casteCategory;
	
	@Column(name = "academic_year")
	private String academicYear;
	
	@Column(name = "roll_number")
	private Long rollNumber;
	
	@Column(name = "admission_date")
	private Date admissionDate;
	
	@Column(name = "admission_number")
	private String admissionNumber;
	
	@Column(name = "route_name")
	private Long routeName;
	
	@Column(name = "pickup_point")
	private String pickupPoint;
	
	@Column(name = "pre_school_name")
	private String previousSchoolName;
	
	@Column(name = "pre_school_address")
	private String preSchoolAddress;
	
	@Column(name = "pre_school_leaving_session")
	private String preSchoolLeavingSession;
	

}
