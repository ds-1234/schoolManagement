package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.ClassEntity;

public interface ClassService {

	ClassEntity save(ClassEntity classEntity);

	List<ClassEntity> getList();

	ClassEntity getAddress(Long id);

}
