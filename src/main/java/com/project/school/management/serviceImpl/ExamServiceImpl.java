package com.project.school.management.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.dto.StudentMarksDto;
import com.project.school.management.entity.ExamEntity;
import com.project.school.management.entity.ExamResultEntity;
import com.project.school.management.entity.StudentMarksEntity;
import com.project.school.management.entity.SubjectWiseExamEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.ExamRepository;
import com.project.school.management.repository.ExamResultRepository;
import com.project.school.management.repository.StudentMarksRepository;
import com.project.school.management.repository.SubjectWiseExamRepository;
import com.project.school.management.request.ExamResultRequest;
import com.project.school.management.request.ExamScheduleRequest;
import com.project.school.management.request.StudentExamResultRequest;
import com.project.school.management.request.SubjectWiseExamList;
import com.project.school.management.request.UpdateExamScheduleRequest;
import com.project.school.management.service.ExamService;
@Service
public class ExamServiceImpl implements ExamService{
	
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private SubjectWiseExamRepository subjectWiseExamRepository;
	
	@Autowired
	private ExamResultRepository examResultRepository;
	
	@Autowired
	private StudentMarksRepository studentMarksRepository;

	@Override
	public ExamEntity saveExam(ExamScheduleRequest examScheduleRequest) {
		ExamEntity entity = new ExamEntity();
		if(!Objects.isNull(examScheduleRequest.getId())) {
			entity.setId(examScheduleRequest.getId());
		}
		entity.setClassName(examScheduleRequest.getClassName());
		entity.setExamName(examScheduleRequest.getExamName());
		entity.setCreatedDate(LocalDate.now());
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
		if(entity.getSubjectWiseExamList().isEmpty()) {
			examRepository.delete(entity);
			return "Exam deleted successfully..";
		}
		return "Please delete exam list first, linked with exam schedule";
		
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
		entity.setId(examResultRequest.getId());
		entity.setTeacherId(examResultRequest.getTeacherid());
		entity.setClassName(examResultRequest.getClassName());
		entity.setSubjectId(examResultRequest.getSubject());
		entity.setIsActive(examResultRequest.getIsActive());
		entity.setExamType(examResultRequest.getExamType());
		
		ExamResultEntity savedExamResult = examResultRepository.save(entity);
		
		 for (StudentMarksDto studentMarksDto : examResultRequest.getStudentMarksMapping()) {
			 StudentMarksEntity studentMarks = new StudentMarksEntity();
			 	studentMarks.setId(studentMarksDto.getId());
	            studentMarks.setStudentId(studentMarksDto.getStudentId());
	            studentMarks.setExamMarks(studentMarksDto.getExamMarks());
	            studentMarks.setRemarks(studentMarksDto.getRemarks());
	            studentMarks.setExamData(savedExamResult);
	            studentMarksRepository.save(studentMarks);
	        }
		return savedExamResult;
		
	}

	@Override
	public List<StudentMarksEntity> getExamResult() {
		return studentMarksRepository.findAll();
	}

	@Override
	public List<StudentMarksEntity> getExamListByTeacherId(Long teacherId, Long examType, Long className) {
		ExamResultEntity entity =  examResultRepository.findByTeacherIdAndExamTypeIdAndClassName(teacherId, examType, className);
		return studentMarksRepository.findAllByExamResultId(entity.getId());
	}

	@Override
	public List<ExamResultEntity> getExamListByStudentId(Long studentId) {
		return examResultRepository.findAll();
	}

	@Override
	public StudentMarksEntity getExamResultById(StudentExamResultRequest studentExamResultRequest) {
		return studentMarksRepository.getByIdAndStudentId(studentExamResultRequest.getId(), studentExamResultRequest.getStudentId()); 
	}
	
	@Override
	public ExamEntity updateExam(UpdateExamScheduleRequest updateExamScheduleRequest) {
		ExamEntity entity = examRepository.findById(updateExamScheduleRequest.getId()).orElseThrow(()->  new IllegalArgumentException("Data no present by given Id"));
		List<SubjectWiseExamEntity> subjectList = entity.getSubjectWiseExamList();
		SubjectWiseExamEntity newAddedExam = new SubjectWiseExamEntity();
		newAddedExam.setSubject(updateExamScheduleRequest.getSubjectWiseExamList().getSubject());
		newAddedExam.setStartTime(updateExamScheduleRequest.getSubjectWiseExamList().getStartTime());
		newAddedExam.setEndTime(updateExamScheduleRequest.getSubjectWiseExamList().getEndTime());
		newAddedExam.setMinMarks(updateExamScheduleRequest.getSubjectWiseExamList().getMinMarks());
		newAddedExam.setMaxMarks(updateExamScheduleRequest.getSubjectWiseExamList().getMaxMarks());
		newAddedExam.setExamDate(updateExamScheduleRequest.getSubjectWiseExamList().getExamDate());
		newAddedExam.setDuration(updateExamScheduleRequest.getSubjectWiseExamList().getDuration());
		subjectList.add(newAddedExam);
		entity.setSubjectWiseExamList(subjectList);
		return examRepository.save(entity);
	}


}
