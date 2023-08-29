package com.project.school.management.request;

import java.util.Date;

import com.project.school.management.enums.Gender;
import com.project.school.management.enums.Role;

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

	Long phone;

	String password;

	String userName;

}
