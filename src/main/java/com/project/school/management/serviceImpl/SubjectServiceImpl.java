package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.Subject;
import com.project.school.management.exception.DataNotExist;
import com.project.school.management.repository.SubjectRepository;
import com.project.school.management.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public Subject save(Subject subject) {
		return this.subjectRepository.save(subject);
	}

	@Override
	public List<Subject> getList() {
		return this.subjectRepository.findAll();
	}

	@Override
	public Subject getAddress(Long id) {
		Optional<Subject> data = this.subjectRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}
		throw new DataNotExist();
	}

}
