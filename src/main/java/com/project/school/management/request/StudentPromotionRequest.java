package com.project.school.management.request;

import java.util.List;

import com.project.school.management.entity.UserEntity;

import lombok.Data;

@Data
public class StudentPromotionRequest {
	List<UserEntity> users;
	String promotedSession;
	List<Long> className;

}
