package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.dto.GradePointsRequestDto;
import com.project.school.management.entity.MasterGradePoints;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.GradePointsRepository;
import com.project.school.management.service.GradePointsService;

@Service
public class GradePointsServiceImpl implements GradePointsService{
	
	@Autowired
	private GradePointsRepository gradePointsRepository;

	@Override
	public List<MasterGradePoints> getGradePointsList() {
		return this.gradePointsRepository.findAll();
	}

	@Override
	public MasterGradePoints save(MasterGradePoints entity) {
		String gradePointId = generateGradePoint();
		entity.setGradePointsId(gradePointId);
		entity.setGrade(entity.getGrade().toUpperCase());
		entity.setPercentageFrom(entity.getPercentageFrom() + " %");
		entity.setPercentageUpto(entity.getPercentageUpto() + " %");
		return this.gradePointsRepository.save(entity);
	}

	private String generateGradePoint() {
		Random random = new Random();
		int randomNumber = 1000 + random.nextInt(9000);
		String generatedId = "GP" + randomNumber;
		return generatedId;
	}

	@Override
	public MasterGradePoints getGradePoints(Long id) {
		Optional<MasterGradePoints> dbData = gradePointsRepository.findById(id);
		if(dbData.isPresent()) {
			return dbData.get();
		}
		throw new NotExist("Grade Points not available by given id");
	}

	@Override
	public Object deleteGradePoints(Long id) {
		Optional<MasterGradePoints> dbData = gradePointsRepository.findById(id);
		if(dbData.isEmpty()) {
			throw new NotExist("grade points data not found by input request");
		}
		gradePointsRepository.delete(dbData.get());
		return "Grade points deleted successfully";
	}

	@Override
	public MasterGradePoints updateTransport(GradePointsRequestDto gradePointsRequestDto) {
		Optional<MasterGradePoints> dbData = gradePointsRepository.findById(gradePointsRequestDto.getId());
		MasterGradePoints entity = dbData.get();
		if(!gradePointsRequestDto.getGrade().isEmpty()) {
			entity.setGrade(gradePointsRequestDto.getGrade());
		}
		if(!gradePointsRequestDto.getGradePoints().isEmpty()) {
			entity.setGradePoints(gradePointsRequestDto.getGradePoints());
		}
		if(!gradePointsRequestDto.getDescription().isEmpty()) {
			entity.setDescription(gradePointsRequestDto.getDescription());
		}
		if(!gradePointsRequestDto.getPercentageFrom().isEmpty()) {
			entity.setPercentageFrom(gradePointsRequestDto.getPercentageFrom());
		}
		if(!gradePointsRequestDto.getPercentageUpto().isEmpty()) {
			entity.setPercentageUpto(gradePointsRequestDto.getPercentageUpto());
		}
		return this.gradePointsRepository.save(entity);
	}

}
