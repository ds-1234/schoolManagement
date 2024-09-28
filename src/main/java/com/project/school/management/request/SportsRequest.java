package com.project.school.management.request;

import com.project.school.management.entity.UserEntity;

import lombok.Data;

@Data
public class SportsRequest {
	private Long id;
	private String sportsId;
	private String sportsName;
    private UserEntity coachName;
	private String startedYear;
	private Boolean isActive;

}
