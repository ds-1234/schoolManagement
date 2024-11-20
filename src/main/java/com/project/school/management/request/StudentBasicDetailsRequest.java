package com.project.school.management.request;

import java.util.Date;

import com.project.school.management.enums.Gender;

import lombok.Data;

@Data
public class StudentBasicDetailsRequest {
	
	String userId;
	
	String firstName;

	String lastName;

	String fatherName;

	String motherName;

	Gender gender;

	Date dateOfBirth;

	Long role;

	String email;

	String phone;
	
	String houseNumber;

	String street;

	Long city;

	Long state;

	String pinCode;

	Long country;
	
	String bloodGroup;
	
	String religion;
	
	String casteCategory;


}
