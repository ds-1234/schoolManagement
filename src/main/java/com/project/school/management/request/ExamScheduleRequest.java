package com.project.school.management.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ExamScheduleRequest {
	Long className;
	Long examName;
	List<SubjectWiseExamList> subjectWiseExamList;

}
