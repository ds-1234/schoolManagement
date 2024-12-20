package com.project.school.management.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.dto.TeacherInfoDto;
import com.project.school.management.entity.ClassSubjectEntity;
import com.project.school.management.entity.Qualification;
import com.project.school.management.entity.TeacherInfoEntity;
import com.project.school.management.entity.UserEntity;
import com.project.school.management.entity.WorkExperience;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.ClassSubjectRepository;
import com.project.school.management.repository.QualificationRepository;
import com.project.school.management.repository.TeacherInfoRepository;
import com.project.school.management.repository.UserRepository;
import com.project.school.management.repository.WorkExperienceRepository;
import com.project.school.management.request.StaffReporteeRequest;
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
	private UserRepository userRepository;

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
		if(ObjectUtils.isNotEmpty(entity)) {
			teacherInfoDto = objectMapper.convertValue(entity, TeacherInfoDto.class);
			teacherInfoDto.setQualificationList(qualificationList);
			teacherInfoDto.setWorkExperience(wrokExperienceList);
			teacherInfoDto.setClassSubjectEntity(classSubjectList);
		}
		return teacherInfoDto;
		
	}

	@Override
	public List<ClassSubjectEntity> getClassSubjectInfo(String id) {
		return classSubjectRepository.findByClassId(id);
	}

	@Override
	public List<ClassSubjectEntity> getClassSubjectInfoData() {
		return classSubjectRepository.findAll();
	}

	@Override
	public List<TeacherInfoEntity> getTeacherInfoList() {
		return teacherInfoRepository.findAll();
	}

	@Override
	public String createStaffReportee(StaffReporteeRequest staffReporteeRequest) {
		TeacherInfoEntity entity= teacherInfoRepository.findByTeacherId(staffReporteeRequest.getSeniorStaffId());
		entity.setManager((long) 0);
		TeacherInfoEntity entity1= teacherInfoRepository.findByTeacherId(staffReporteeRequest.getStaffId());
		entity1.setReportee(Long.parseLong(staffReporteeRequest.getSeniorStaffId()));
		teacherInfoRepository.save(entity);
		teacherInfoRepository.save(entity1);
		return "Manager assigned successfully";
	}

	@Override
	public List<String> getReporteeList(Long managerId) {
		List<TeacherInfoEntity> list = teacherInfoRepository.findAllByReportee(managerId);
		List<String> userList = new ArrayList<>();
		for(TeacherInfoEntity entity:list) {
			UserEntity user = userRepository.findById(entity.getReportee())
					.orElseThrow(()-> new InvalidArgumentException("User not present by given id"));
			String userName = user.getFirstName() + " " +user.getLastName();
			userList.add(userName);
		}
		
		return userList;
	}

}
