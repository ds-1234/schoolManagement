package com.project.school.management.request;

import java.util.List;

import com.project.school.management.dto.StudentMarksDto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ExamResultRequest {
	
	
	@NonNull
	Long teacherid;
	
	@NotNull(message = "Class name must not be null")
	Long className;
	
	@NonNull
	Long subject;
	
	@NonNull
	Boolean isActive;
	
	@NonNull
	Long examType;
	
	List<StudentMarksDto> studentMarksMapping;

}
