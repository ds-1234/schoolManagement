package com.project.school.management.request;

import java.util.Date;

import com.project.school.management.entity.ClassEntity;
import com.project.school.management.entity.UserEntity;

import lombok.Data;
@Data
public class AttendanceRequest {
	
	Long id;
	
	UserEntity student;
	
    UserEntity teacher;
	
	ClassEntity className;
	
	Date attendanceDate;
	
	String attendanceStatus;

}
