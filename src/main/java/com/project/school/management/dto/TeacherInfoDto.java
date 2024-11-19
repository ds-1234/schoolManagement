package com.project.school.management.dto;

import java.util.List;

import com.project.school.management.entity.ClassSubjectEntity;
import com.project.school.management.entity.Qualification;
import com.project.school.management.entity.WorkExperience;

import lombok.Data;

@Data
public class TeacherInfoDto {
	
	private Long id;

	private String teacherId;

	private String maritalStatus;

	private List<Qualification> qualificationList;
	
	private List<ClassSubjectEntity> classSubjectEntity;

	private List<WorkExperience> workExperience;

	private String previousSchool;
	
	private Long designation;

	private String aadhar;
	
	private String languages;

	private String pan;

	private String accountNumber;

	private String accountName;

	private String bankName;

	private String ifsc;

	private String branchName;
	
	private Long department;

}
