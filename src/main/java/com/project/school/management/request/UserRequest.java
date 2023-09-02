package com.project.school.management.request;

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

	String firstName;

	String lastName;

	String fatherName;

	String motherName;

	Gender gender;

	Date dateOfBirth;

	Role role;

	String email;

	String phone;

	String password;

	String userName;

	String userId;

	String houseNumber;

	String street;

	String city;

	String state;

	String pinCode;

	String country;

	List<String> isParent;

	ClassEntity className;

	List<Book> book;

	School school;

	Boolean isActive;

}
