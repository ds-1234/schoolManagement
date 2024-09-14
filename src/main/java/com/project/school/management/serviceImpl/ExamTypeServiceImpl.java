package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.dto.ExamTypeDto;
import com.project.school.management.entity.MasterExamType;
import com.project.school.management.exception.InvalidRequestException;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.ExamTypeRepository;
import com.project.school.management.service.ExamTypeService;
@Service
public class ExamTypeServiceImpl implements ExamTypeService{
	
	@Autowired
	private ExamTypeRepository examTypeRepository;

	@Override
	public List<MasterExamType> getExamTypeList() {
		return this.examTypeRepository.findAll();
	}

	@Override
	public MasterExamType save(MasterExamType entity) {
		String examTypeId = generateExamTypeId();
		entity.setExamTypeId(examTypeId);
		entity.setExamTypeName(entity.getExamTypeName().toUpperCase());
		return this.examTypeRepository.save(entity);
	}

	private String generateExamTypeId() {
		Random random = new Random();
		int randomNumber = 1000 + random.nextInt(9000);
		String generatedId = "ET" + randomNumber;
		return generatedId;
	}

	@Override
	public MasterExamType updateExamType(ExamTypeDto examTypeDto) {
		Optional<MasterExamType> dbData = examTypeRepository.findById(examTypeDto.getId());
		if(dbData.isEmpty()) {
			throw new InvalidRequestException("exam type data not found by input request");
		}
		MasterExamType entity = dbData.get();
		if(!examTypeDto.getExamTypeName().isEmpty()) {
			entity.setExamTypeName(examTypeDto.getExamTypeName());
		}
		if(!examTypeDto.getExamTypeDescription().isEmpty()) {
			entity.setExamTypeDescription(examTypeDto.getExamTypeDescription());
		}
		return this.examTypeRepository.save(entity);
	}

	@Override
	public MasterExamType getTransport(Long id) {
		Optional<MasterExamType> dbData = examTypeRepository.findById(id);
		if(dbData.isPresent()) {
			return dbData.get();
		}
		throw new NotExist("Exam Type data not present by given id");
	}

	@Override
	public Object deleteExamType(Long id) {
		Optional<MasterExamType> dbData = examTypeRepository.findById(id);
		if(dbData.isEmpty()) {
			throw new NotExist("exam type data not found by input request");
		}
		examTypeRepository.delete(dbData.get());
		return "Exam Type Data deleted successfully";
	}

}
