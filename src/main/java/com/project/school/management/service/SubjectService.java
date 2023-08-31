package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.Subject;

public interface SubjectService {

	Subject save(Subject subject);

	List<Subject> getList();

	Subject getAddress(Long id);

}
