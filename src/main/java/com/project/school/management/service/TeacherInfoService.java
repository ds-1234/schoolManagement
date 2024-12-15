package com.project.school.management.service;

import java.util.List;

import com.project.school.management.dto.TeacherInfoDto;
import com.project.school.management.entity.ClassSubjectEntity;
import com.project.school.management.entity.TeacherInfoEntity;

public interface TeacherInfoService {


	TeacherInfoDto createTeacherInfo(TeacherInfoDto dto);

	TeacherInfoDto getTeacherInfo(String id);

	List<ClassSubjectEntity> getClassSubjectInfo(String id);

	List<ClassSubjectEntity> getClassSubjectInfoData();

	List<TeacherInfoEntity> getTeacherInfoList();

}
