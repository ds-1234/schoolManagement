package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.School;

public interface SchoolService {

	School save(School school);

	List<School> getList();

	School getAddress(Long id);

}
