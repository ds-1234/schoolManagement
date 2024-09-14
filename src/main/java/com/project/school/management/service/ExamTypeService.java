package com.project.school.management.service;

import java.util.List;

import com.project.school.management.dto.ExamTypeDto;
import com.project.school.management.entity.MasterExamType;

public interface ExamTypeService {

	List<MasterExamType> getExamTypeList();

	MasterExamType save(MasterExamType entity);

	MasterExamType updateExamType(ExamTypeDto examTypeDto);

	MasterExamType getTransport(Long id);

	Object deleteExamType(Long id);

}
