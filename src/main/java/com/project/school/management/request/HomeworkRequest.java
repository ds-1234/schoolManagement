package com.project.school.management.request;

import java.time.LocalDate;
import java.util.Date;

import com.project.school.management.entity.ClassEntity;
import com.project.school.management.entity.Subject;
import com.project.school.management.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class HomeworkRequest {
	Long id;
	UserEntity user;
	ClassEntity className;
	Subject subjectName;
	Date homeworkDate;
	Date submissionDate;
	Boolean isActive;

}
