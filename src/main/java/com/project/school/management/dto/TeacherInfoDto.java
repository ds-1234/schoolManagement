package com.project.school.management.dto;

import java.util.Date;
import java.util.List;

import com.project.school.management.entity.Qualification;
import com.project.school.management.entity.WrokExperience;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class TeacherInfoDto {
	
	private Long id;

	private String teacherId;

	private String maritalStatus;

	private List<Qualification> qualificationList;

	private List<WrokExperience> workExperience;

	private String previousSchool;

	private String aadhar;

	private String pan;

	private String accountNumber;

	private String accountName;

	private String bankName;

	private String ifsc;

	private String branchName;

}
