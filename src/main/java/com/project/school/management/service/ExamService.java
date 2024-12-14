package com.project.school.management.service;

import java.util.List;
import java.util.Map;

import com.project.school.management.entity.ExamEntity;
import com.project.school.management.entity.ExamResultEntity;
import com.project.school.management.entity.StudentMarksEntity;
import com.project.school.management.entity.SubjectWiseExamEntity;
import com.project.school.management.request.ExamResultRequest;
import com.project.school.management.request.ExamResultRequestForAdmin;
import com.project.school.management.request.ExamScheduleRequest;
import com.project.school.management.request.StudentExamResultRequest;
import com.project.school.management.request.UpdateExamScheduleRequest;
import com.project.school.management.response.ExamResultResponseForAdmin;

public interface ExamService {

	ExamEntity saveExam(ExamScheduleRequest examScheduleRequest);

	List<ExamEntity> getExam();

	ExamEntity getExamById(Long id);

	Object deleteExam(Long id);

	Object deleteSubjectFromExamList(Long id);

	SubjectWiseExamEntity getSubjectFromExamListById(Long id);

	ExamResultEntity saveExamResult(ExamResultRequest examResultRequest);

	List<StudentMarksEntity> getExamResult();

	List<StudentMarksEntity> getExamListByTeacherId(Long teacherId, Long examType, Long className);

	List<ExamResultEntity> getExamListByStudentId(Long studentId);

	StudentMarksEntity getExamResultById(StudentExamResultRequest studentExamResultRequest);

	ExamEntity updateExam(UpdateExamScheduleRequest updateExamScheduleRequest);

	Map<String, List<ExamResultResponseForAdmin.SubjectResult>> getExamResultForAdmin(ExamResultRequestForAdmin examResultRequestForAdmin);

}
