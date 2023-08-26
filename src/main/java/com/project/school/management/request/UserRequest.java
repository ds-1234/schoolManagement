package com.project.school.management.request;

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
public class UserRequest{
	
	String email;
	
	Long phone;
	
	Role role;
	
	String password;
	
	String name;
	
	Gender gender;

}
