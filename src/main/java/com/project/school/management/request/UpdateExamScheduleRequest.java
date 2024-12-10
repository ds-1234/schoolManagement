package com.project.school.management.request;

import java.util.List;

import lombok.Data;

@Data
public class UpdateExamScheduleRequest {
	Long id;
	SubjectWiseExamList subjectWiseExamList;

}
