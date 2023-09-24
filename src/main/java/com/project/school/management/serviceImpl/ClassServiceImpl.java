package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.ClassEntity;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.ClassRepository;
import com.project.school.management.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassRepository classRepository;

	@Override
	public ClassEntity save(ClassEntity classEntity) {
		return this.classRepository.save(classEntity);
	}

	@Override
	public List<ClassEntity> getList() {
		return this.classRepository.findAll();
	}

	@Override
	public ClassEntity getAddress(Long id) {
		Optional<ClassEntity> data = this.classRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}
		throw new NotExist();
	}

}
