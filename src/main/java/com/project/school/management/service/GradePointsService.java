package com.project.school.management.service;

import java.util.List;

import com.project.school.management.dto.GradePointsRequestDto;
import com.project.school.management.entity.MasterGradePoints;

public interface GradePointsService {

	List<MasterGradePoints> getGradePointsList();

	MasterGradePoints save(MasterGradePoints entity);

	MasterGradePoints getGradePoints(Long id);

	Object deleteGradePoints(Long id);

	MasterGradePoints updateTransport(GradePointsRequestDto gradePointsRequestDto);

}
