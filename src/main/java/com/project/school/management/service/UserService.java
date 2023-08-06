package com.project.school.management.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.project.school.management.entity.StudentEntity;
import com.project.school.management.request.AddStudentRequest;
import com.project.school.management.request.LoginRequest;
import com.project.school.management.request.UserRequest;

public interface UserService{

	ResponseEntity<Object> saveUserDetail(UserRequest userRequest) throws IOException;

	ResponseEntity<Object> login(LoginRequest loginRequest) throws IOException;

	ResponseEntity<Object> saveStudentDetail(AddStudentRequest request) throws IOException;

	ResponseEntity<Object> getStudent() throws IOException;

	ResponseEntity<Object> getStudent(Integer id) throws IOException;

}
