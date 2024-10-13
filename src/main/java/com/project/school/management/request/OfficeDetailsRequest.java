package com.project.school.management.request;

import java.sql.Date;

import lombok.Data;

@Data
public class OfficeDetailsRequest {
	String userId;
	Date admissionDate;
	String admissionNumber;

}
