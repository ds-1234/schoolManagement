package com.project.school.management.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest{
	
	String email;
	
	Long phone;
	
	Integer role;
	
	String password;

}
