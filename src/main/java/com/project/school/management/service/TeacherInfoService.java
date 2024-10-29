package com.project.school.management.service;

import com.project.school.management.dto.TeacherInfoDto;

public interface TeacherInfoService {


	TeacherInfoDto createTeacherInfo(TeacherInfoDto dto);

	TeacherInfoDto createTeacherInfo(String id);

}
