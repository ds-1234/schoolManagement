package com.project.school.management.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.dto.RoleUserStats;
import com.project.school.management.entity.Role;
import com.project.school.management.repository.RoleRepository;
import com.project.school.management.repository.UserRepository;
import com.project.school.management.service.AdminDashboardService;

@Service
public class AdminDashboardServiceImpl implements AdminDashboardService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Map<String, RoleUserStats> getCount() {
		List<Object[]> results = userRepository.getUserCountByRoleAndStatus();

		// Convert the results to a nested Map (role -> (status -> count))
		Map<String, RoleUserStats> roleStatusCountMap = new HashMap<>();

		for (Object[] result : results) {
			Long roleId = (Long) result[0];
			Boolean status = (Boolean) result[1];
			Long count = (Long) result[2];
			
			Optional<Role> role = roleRepository.findById(roleId);
	            String roleName = role.map(Role::getName).orElse("Unknown");
	            
            RoleUserStats stats = roleStatusCountMap.computeIfAbsent(roleName, k -> new RoleUserStats());
            
            if (status) {
                stats.setActiveCount(count);  // If status is true, it's active
            } else {
                stats.setInactiveCount(count);  // If status is false, it's inactive
            }

            stats.setTotalCount(stats.getActiveCount() + stats.getInactiveCount());
		}

		return roleStatusCountMap;
	}
}
