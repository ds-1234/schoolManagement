package com.project.school.management.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

public interface AdminDashService {

	ResponseEntity<Object> getStudent(String role) throws IOException;

	ResponseEntity<Object> getBoysAndGirls(String role) throws IOException;

}
