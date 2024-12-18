package com.project.school.management.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.school.management.entity.Book;
import com.project.school.management.entity.ClassEntity;
import com.project.school.management.entity.Role;
import com.project.school.management.entity.School;
import com.project.school.management.enums.Gender;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
	
	Long id;

	String firstName;

	String lastName;

	String fatherName;

	String motherName;

	Gender gender;

	Date dateOfBirth;

	Long role;

	String email;

	String phone;

	String password;

	String userName;

	String userId;

	String houseNumber;

	String street;

	Long city;

	Long state;

	String pinCode;

	Long country;

	List<Long> isParent;

	List<Long> className = new ArrayList<>();;

	List<Long> book = new ArrayList<>();

	Long school;

	Boolean isActive;
	
	String bloodGroup;
	
	String religion;
	
	String casteCategory;

}
