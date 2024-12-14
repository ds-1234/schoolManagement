package com.project.school.management.response;

import java.util.ArrayList;
import java.util.List;

public class ExamResultResponseForAdmin {
	private String fullName;
	private List<SubjectResult> subjectResults;

// Constructor, Getters, Setters

	public ExamResultResponseForAdmin(String firstName, String lastName, String subjectName, Long examMarks, String remarks) {
	    this.fullName = firstName + " " + lastName;
	    this.subjectResults = new ArrayList<>();
	    this.subjectResults.add(new SubjectResult(subjectName, examMarks, remarks));
	}

	public void addSubjectResult(String subjectName, Long examMarks, String remarks) {
		this.subjectResults.add(new SubjectResult(subjectName, examMarks, remarks));
	}

	public String getFullName() {
		return fullName;
	}

	public List<SubjectResult> getSubjectResults() {
		return subjectResults;
	}

	public static class SubjectResult {
		private String subjectName;
		private Long examMarks;
		private String remarks;

		// Constructor, Getters, Setters

		public SubjectResult(String subjectName, Long examMarks, String remarks) {
			this.subjectName = subjectName;
			this.examMarks = examMarks;
			this.remarks = remarks;
		}

		public String getSubjectName() {
			return subjectName;
		}

		public Long getExamMarks() {
			return examMarks;
		}

		public String getRemarks() {
			return remarks;
		}
	}
}
