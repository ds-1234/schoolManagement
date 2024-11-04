package com.project.school.management.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "teacherInfo")
public class TeacherInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Teacher ids", nullable = false)
	private String teacherId;

	@Column(name = "Marital Status", nullable = true)
	private String maritalStatus;

	@Column(name = "Previous School", nullable = true)
	private String previousSchool;

	@Column(name = "aadhar card number", nullable = true)
	private String aadhar;

	@Column(name = "pan", nullable = true)
	private String pan;

	@Column(name = "account number", nullable = true)
	private String accountNumber;

	@Column(name = "account name ", nullable = true)
	private String accountName;

	@Column(name = "bank name", nullable = true)
	private String bankName;

	@Column(name = "IFSC code", nullable = true)
	private String ifsc;

	@Column(name = "branch name", nullable = true)
	private String branchName;

}
