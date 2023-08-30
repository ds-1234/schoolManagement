package com.project.school.management.request;

import java.util.Date;
import java.util.List;

import com.project.school.management.entity.Address;
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

	private String firstName;

	private String lastName;

	private String fatherName;

	private String motherName;

	private Gender gender;

	private Date dateOfBirth;

	private Address address;

	private Role role;

	private String email;

	private Long phone;

	private String password;

	private String userName;

	private String userId;

	private List<String> isParent;

	private List<String> className;

	private List<String> section;

	private School school;

	private Boolean isActive;

}
