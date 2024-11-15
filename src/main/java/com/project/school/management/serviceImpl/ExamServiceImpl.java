package com.project.school.management.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.ExamEntity;
import com.project.school.management.entity.SubjectWiseExamEntity;
import com.project.school.management.repository.ExamRepository;
import com.project.school.management.request.ExamScheduleRequest;
import com.project.school.management.request.SubjectWiseExamList;
import com.project.school.management.service.ExamService;
@Service
public class ExamServiceImpl implements ExamService{
	
	@Autowired
	private ExamRepository examRepository;

	@Override
	public ExamEntity saveExam(ExamScheduleRequest examScheduleRequest) {
		ExamEntity entity = new ExamEntity();
		entity.setClassName(examScheduleRequest.getClassName());
		entity.setExamName(examScheduleRequest.getExamName());
		List<SubjectWiseExamList> list = examScheduleRequest.getSubjectWiseExamList();
		List<SubjectWiseExamEntity> subjectExamList = new ArrayList<>();
		for(SubjectWiseExamList data :list) {
			SubjectWiseExamEntity examData = new SubjectWiseExamEntity();
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

}
