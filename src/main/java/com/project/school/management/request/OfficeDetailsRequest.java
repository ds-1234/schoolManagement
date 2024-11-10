package com.project.school.management.request;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class OfficeDetailsRequest {
	String userId;
	Date admissionDate;
	String admissionNumber;
	List<Long> siblings;
	List<String> knownAllergies;
	List<String> medications;

}
