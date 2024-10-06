package com.project.school.management.request;

import lombok.Data;

@Data
public class SportsRequest {
	private Long id;
	private String sportsId;
	private String sportsName;
    private Long userId;
	private String startedYear;
	private Boolean isActive;

}
