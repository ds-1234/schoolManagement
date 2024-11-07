package com.project.school.management.serviceImpl;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.dto.TeacherInfoDto;
import com.project.school.management.entity.Qualification;
import com.project.school.management.entity.TeacherInfoEntity;
import com.project.school.management.entity.WrokExperience;
import com.project.school.management.exception.AlreadyExistException;
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
	private ObjectMapper objectMapper;

	@Override
	@Transactional
	public TeacherInfoDto createTeacherInfo(TeacherInfoDto dto) {
		if (ObjectUtils.isNotEmpty(dto.getWorkExperience())) {
			List<WrokExperience> wrokExperienceList =  workExperienceRepository.findByTeacherId(dto.getTeacherId());
			if(ObjectUtils.isNotEmpty(wrokExperienceList)) {
				workExperienceRepository.deleteAll(wrokExperienceList);
			}
			workExperienceRepository.saveAll(dto.getWorkExperience());
		}
		if (ObjectUtils.isNotEmpty(dto.getQualificationList())) {
			List<Qualification> qualificationList =  qualificationRepository.findByTeacherId(dto.getTeacherId());
			if(ObjectUtils.isNotEmpty(qualificationList)) {
				qualificationRepository.deleteAll(qualificationList);
			}
			qualificationRepository.saveAll(dto.getQualificationList());
		}

		
		TeacherInfoEntity teacherInfoEntity = teacherInfoRepository.findByTeacherId(dto.getTeacherId());
		
		TeacherInfoEntity entity = objectMapper.convertValue(dto, TeacherInfoEntity.class);

		if(ObjectUtils.isNotEmpty(teacherInfoEntity) && StringUtils.isNotEmpty(teacherInfoEntity.getId().toString())) {
			entity.setId(teacherInfoEntity.getId());
		}
		
		
//		if(ObjectUtils.isNotEmpty(teacherInfoEntity)) {
//			teacherInfoRepository.delete(teacherInfoEntity);
//		}
		
		teacherInfoRepository.save(entity);

		return dto;
	}

	@Override
	public TeacherInfoDto createTeacherInfo(String id) {
		TeacherInfoDto teacherInfoDto = new TeacherInfoDto();
		
		TeacherInfoEntity entity= teacherInfoRepository.findByTeacherId(id);
		List<WrokExperience> wrokExperienceList = workExperienceRepository.findByTeacherId(id);
		List<Qualification> qualificationList= qualificationRepository.findByTeacherId(id);
		
		teacherInfoDto = objectMapper.convertValue(entity, TeacherInfoDto.class);
		if(ObjectUtils.isNotEmpty(qualificationList)) {
			teacherInfoDto.setQualificationList(qualificationList);
		}
		
		if(ObjectUtils.isNotEmpty(wrokExperienceList)) {
			teacherInfoDto.setWorkExperience(wrokExperienceList);
		}
		
		return teacherInfoDto;
		
	}

}
