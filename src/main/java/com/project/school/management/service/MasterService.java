package com.project.school.management.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.project.school.management.entity.BloodGroupEntity;
import com.project.school.management.entity.GenderEntity;
import com.project.school.management.entity.GradeEntity;
import com.project.school.management.entity.GradeSectionEntity;
import com.project.school.management.entity.MasterHoliday;
import com.project.school.management.entity.RoleEntity;
import com.project.school.management.request.SubjectRequest;

public interface MasterService {

	ResponseEntity<Object> saveRole(RoleEntity roleEntity) throws IOException;

	ResponseEntity<Object> getRole() throws IOException;

	ResponseEntity<Object> saveGrade(GradeEntity gradeEntity) throws IOException;

	ResponseEntity<Object> saveGradeSection(GradeSectionEntity gradeSecEntity) throws IOException;

	ResponseEntity<Object> getGradeSection() throws IOException;

	ResponseEntity<Object> getGrade() throws IOException;

	ResponseEntity<Object> saveGender(GenderEntity genderEntity) throws IOException;

	ResponseEntity<Object> saveBloodGroup(BloodGroupEntity bloodGroupEntity) throws IOException;

	ResponseEntity<Object> getGender() throws IOException;

	ResponseEntity<Object> getBloodGroup() throws IOException;

	ResponseEntity<Object> saveSubject(SubjectRequest subjectRequest) throws IOException;

	ResponseEntity<Object> getSubject() throws IOException;

	ResponseEntity<Object> saveHoliday(MasterHoliday masterHoliday) throws IOException;

	ResponseEntity<Object> getHoliday() throws IOException;

}
