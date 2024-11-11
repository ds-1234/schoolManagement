package com.project.school.management.request;

import java.sql.Date;

import lombok.Data;
@Data
public class BookIssueRequest {
	Long id;
	String userId;
	Date issuedDate;
	Date returnDate;
	String bookNumber;
	Long bookMapping;
	Boolean isActive;

}
