package com.project.school.management.service;

import java.util.Map;

import com.project.school.management.dto.RoleUserStats;

public interface AdminDashboardService {

	Map<String, RoleUserStats> getCount();

}
