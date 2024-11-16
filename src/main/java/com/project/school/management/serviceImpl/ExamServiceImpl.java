package com.project.school.management.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.ExamEntity;
import com.project.school.management.entity.ExamResultEntity;
import com.project.school.management.entity.SubjectWiseExamEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.ExamRepository;
import com.project.school.management.repository.ExamResultRepository;
import com.project.school.management.repository.SubjectWiseExamRepository;
import com.project.school.management.request.ExamResultRequest;
import com.project.school.management.request.ExamScheduleRequest;
import com.project.school.management.request.SubjectWiseExamList;
import com.project.school.management.service.ExamService;
@Service
public class ExamServiceImpl implements ExamService{
	
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private SubjectWiseExamRepository subjectWiseExamRepository;
	
	@Autowired
	private ExamResultRepository examResultRepository;

	@Override
	public ExamEntity saveExam(ExamScheduleRequest examScheduleRequest) {
		ExamEntity entity = new ExamEntity();
		if(!Objects.isNull(examScheduleRequest.getId())) {
			entity.setId(examScheduleRequest.getId());
		}
		entity.setClassName(examScheduleRequest.getClassName());
		entity.setExamName(examScheduleRequest.getExamName());
		List<SubjectWiseExamList> list = examScheduleRequest.getSubjectWiseExamList();
		List<SubjectWiseExamEntity> subjectExamList = new ArrayList<>();
		for(SubjectWiseExamList data :list) {
			SubjectWiseExamEntity examData = new SubjectWiseExamEntity();
			if(!Objects.isNull(data.getId())) {
				examData.setId(data.getId());
			}
			examData.setSubject(data.getSubject());
			examData.setStartTime(data.getStartTime());
			examData.setEndTime(data.getEndTime());
			examData.setMinMarks(data.getMinMarks());
			examData.setMaxMarks(data.getMaxMarks());
			examData.setExamDate(data.getExamDate());
			examData.setDuration(data.getDuration());
			subjectExamList.add(examData);
		}
		entity.setSubjectWiseExamList(subjectExamList);
		
		return examRepository.save(entity);
	}

	@Override
	public List<ExamEntity> getExam() {
		return examRepository.findAll();
	}

	@Override
	public ExamEntity getExamById(Long id) {
		ExamEntity entity = examRepository.findById(id).
				orElseThrow(()-> new InvalidArgumentException("Given id is invalid or data not present"));
		return entity;
	}

	@Override
	public Object deleteExam(Long id) {
		ExamEntity entity = examRepository.findById(id).
				orElseThrow(()-> new InvalidArgumentException("Given id is invalid or data not present"));
		examRepository.delete(entity);
		return "Exam deleted successfully..";
	}

	@Override
	public Object deleteSubjectFromExamList(Long id) {
		SubjectWiseExamEntity examEntity = subjectWiseExamRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or data not present"));
		subjectWiseExamRepository.delete(examEntity);
		return "Subject data deleted from exam";
	}

	@Override
	public SubjectWiseExamEntity getSubjectFromExamListById(Long id) {
		return subjectWiseExamRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or data not present"));
	}

	@Override
	public ExamResultEntity saveExamResult(ExamResultRequest examResultRequest) {
		ExamResultEntity entity = new ExamResultEntity();
		if(Objects.isNull(examResultRequest.getId())) {
			entity.setClassName(examResultRequest.getClassName());
			entity.setRemarks(examResultRequest.getRemarks());
			entity.setStudentId(examResultRequest.getStudentId());
			entity.setSubjectId(examResultRequest.getSubject());
			entity.setSubjectMarks(examResultRequest.getSubjectMarks());
			entity.setTeacherId(examResultRequest.getTeacherid());
			entity.setIsActive(examResultRequest.getIsActive());
			return examResultRepository.save(entity);
		}else {
			entity.setId(examResultRequest.getId());
			entity.setClassName(examResultRequest.getClassName());
			entity.setRemarks(examResultRequest.getRemarks());
			entity.setStudentId(examResultRequest.getStudentId());
			entity.setSubjectId(examResultRequest.getSubject());
			entity.setSubjectMarks(examResultRequest.getSubjectMarks());
			entity.setTeacherId(examResultRequest.getTeacherid());
			entity.setIsActive(examResultRequest.getIsActive());
			return examResultRepository.save(entity);
		}
	}

	@Override
	public List<ExamResultEntity> getExamResult() {
		return examResultRepository.findAll();
	}

	@Override
	public List<ExamResultEntity> getExamListByTeacherId(Long teacherId) {
		return examResultRepository.findAllByTeacherId(teacherId);
	}

	@Override
	public List<ExamResultEntity> getExamListByStudentId(Long studentId) {
		return examResultRepository.findAllByStudentId(studentId);
	}

	@Override
	public ExamResultEntity getExamResultById(Long id) {
		return examResultRepository.findById(id).
				orElseThrow(()-> new InvalidArgumentException("Data is empty or id is invalid"));
	}

}
