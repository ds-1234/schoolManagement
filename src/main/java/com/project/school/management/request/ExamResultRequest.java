package com.project.school.management.request;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ExamResultRequest {
	Long id;
	
	@NonNull
	Long studentId;
	
	@NonNull
	Long teacherid;
	
	@NonNull
	String subjectMarks;
	
	@NotNull(message = "Class name must not be null")
	Long className;
	
	@NonNull
	Long subject;
	
	@NonNull
	Boolean isActive;
	
	String remarks;

}
