package com.project.school.management.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class AddStudentRequest {

	private String firstName;

	private String lastName;

	private Integer gender;

	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date dateOfBirth;

	private Integer grade;
	
	private Integer gradeSection;

	private String address;

	private Long parentsContact;
	
	private String admissionId;
	
	private Integer bloodGroup;
	
	private String email;


}
