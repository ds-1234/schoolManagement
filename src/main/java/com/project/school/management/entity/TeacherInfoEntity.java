package com.project.school.management.entity;

import java.sql.Date;
import java.util.List;

import com.project.school.management.dto.LeaveCounterDto;

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

	@Column(name = "Teacher ids")
	private String teacherId;

	@Column(name = "Marital Status")
	private String maritalStatus;

	@Column(name = "Previous School")
	private String previousSchool;

	@Column(name = "aadhar card number")
	private String aadhar;
	
	@Column(name = "languages")
	private String languages;
	
	@Column(name = "designation")
	private Long designation;

	@Column(name = "pan")
	private String pan;

	@Column(name = "account number")
	private String accountNumber;

	@Column(name = "account name ")
	private String accountName;

	@Column(name = "bank name")
	private String bankName;

	@Column(name = "IFSC code")
	private String ifsc;

	@Column(name = "branch name")
	private String branchName;
	
	@Column(name = "department")
	private Long department;
	
	@Column(name = "epf_number")
	private String epfNumber;
	
	@Column(name = "basic_salary")
	private String basicSalary;
	
	@Column(name = "contract_type")
	private String contractType;
	
	@Column(name = "work_shift")
	private String workShift;
	
	@Column(name = "work_location")
	private String workLocation;
	
	@Column(name = "employee_number")
	private String employeeNumber;
	
	@Column(name = "manager")
	private Long manager;
	
	@Column(name = "reportee")
	private Long reportee;
	
	@Column(name = "date_of_joining")
	private Date dateOfJoining;
	
	@Column(name = "date_of_leaving")
	private Date dateOfLeaving;

}
