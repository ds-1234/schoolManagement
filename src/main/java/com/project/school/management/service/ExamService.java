package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.ExamEntity;
import com.project.school.management.entity.ExamResultEntity;
import com.project.school.management.entity.SubjectWiseExamEntity;
import com.project.school.management.request.ExamResultRequest;
import com.project.school.management.request.ExamScheduleRequest;

public interface ExamService {

	ExamEntity saveExam(ExamScheduleRequest examScheduleRequest);

	List<ExamEntity> getExam();

	ExamEntity getExamById(Long id);

	Object deleteExam(Long id);

	Object deleteSubjectFromExamList(Long id);

	SubjectWiseExamEntity getSubjectFromExamListById(Long id);

	ExamResultEntity saveExamResult(ExamResultRequest examResultRequest);

	List<ExamResultEntity> getExamResult();

	List<ExamResultEntity> getExamListByTeacherId(Long teacherId);

	List<ExamResultEntity> getExamListByStudentId(Long studentId);

	ExamResultEntity getExamResultById(Long id);

}
