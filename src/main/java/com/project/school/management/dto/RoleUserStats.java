package com.project.school.management.dto;

import lombok.Data;

@Data
public class RoleUserStats {
	private Long activeCount = 0L;
    private Long inactiveCount = 0L;
    private Long totalCount = 0L;

}
