package com.project.school.management.serviceImpl;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.dto.TeacherInfoDto;
import com.project.school.management.entity.ClassSubjectEntity;
import com.project.school.management.entity.Qualification;
import com.project.school.management.entity.TeacherInfoEntity;
import com.project.school.management.entity.WorkExperience;
import com.project.school.management.repository.ClassSubjectRepository;
import com.project.school.management.repository.QualificationRepository;
import com.project.school.management.repository.TeacherInfoRepository;
import com.project.school.management.repository.WorkExperienceRepository;
import com.project.school.management.service.TeacherInfoService;

import jakarta.transaction.Transactional;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

	@Autowired
	private TeacherInfoRepository teacherInfoRepository;

	@Autowired
	private WorkExperienceRepository workExperienceRepository;

	@Autowired
	private QualificationRepository qualificationRepository;
	
	@Autowired
	private ClassSubjectRepository classSubjectRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	@Transactional
	public TeacherInfoDto createTeacherInfo(TeacherInfoDto dto) {
		if(ObjectUtils.isNotEmpty(dto.getWorkExperience())) {
			workExperienceRepository.saveAll(dto.getWorkExperience());
		}
		if(ObjectUtils.isNotEmpty(dto.getQualificationList())) {
			qualificationRepository.saveAll(dto.getQualificationList());
		}
		
		if(ObjectUtils.isNotEmpty(dto.getClassSubjectEntity())) {
			classSubjectRepository.saveAll(dto.getClassSubjectEntity());
		}

		TeacherInfoEntity entity = objectMapper.convertValue(dto, TeacherInfoEntity.class);

		teacherInfoRepository.save(entity);

		return dto;
	}

	@Override
	public TeacherInfoDto getTeacherInfo(String id) {
		TeacherInfoDto teacherInfoDto = new TeacherInfoDto();
		
		TeacherInfoEntity entity= teacherInfoRepository.findByTeacherId(id);
		List<WorkExperience> wrokExperienceList = workExperienceRepository.findByTeacherId(id);
		List<Qualification> qualificationList= qualificationRepository.findByTeacherId(id);
		List<ClassSubjectEntity> classSubjectList= classSubjectRepository.findByTeacherId(id);
		
		teacherInfoDto = objectMapper.convertValue(entity, TeacherInfoDto.class);
		teacherInfoDto.setQualificationList(qualificationList);
		teacherInfoDto.setWorkExperience(wrokExperienceList);
		teacherInfoDto.setClassSubjectEntity(classSubjectList);
		return teacherInfoDto;
		
	}

}
