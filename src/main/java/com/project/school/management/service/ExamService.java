package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.ExamEntity;
import com.project.school.management.entity.SubjectWiseExamEntity;
import com.project.school.management.request.ExamScheduleRequest;

public interface ExamService {

	ExamEntity saveExam(ExamScheduleRequest examScheduleRequest);

	List<ExamEntity> getExam();

	ExamEntity getExamById(Long id);

	Object deleteExam(Long id);

	Object deleteSubjectFromExamList(Long id);

	SubjectWiseExamEntity getSubjectFromExamListById(Long id);

}
