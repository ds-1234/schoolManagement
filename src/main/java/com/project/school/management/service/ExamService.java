package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.ExamEntity;
import com.project.school.management.request.ExamScheduleRequest;

public interface ExamService {

	ExamEntity saveExam(ExamScheduleRequest examScheduleRequest);

	List<ExamEntity> getExam();

}
