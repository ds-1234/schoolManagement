package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.constant.Message;
import com.project.school.management.entity.Subject;
import com.project.school.management.exception.AlreadyExistException;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.SubjectRepository;
import com.project.school.management.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public Subject save(Subject subject) {
		if (ObjectUtils.isNotEmpty(this.subjectRepository.findBySubjectIgnoreCase(subject.getSubject()))) {
			throw new AlreadyExistException(Message.SUBJECT_ALREADY_EXIST);
		}
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
		throw new NotExist(Message.SUBJECT_NOT_EXIST);
	}

}
