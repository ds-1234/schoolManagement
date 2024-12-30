package com.project.school.management.serviceImpl;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.dto.RoleUserStats;
import com.project.school.management.entity.AmountCollections;
import com.project.school.management.entity.Role;
import com.project.school.management.repository.AmountCollectionRepository;
import com.project.school.management.repository.RoleRepository;
import com.project.school.management.repository.UserRepository;
import com.project.school.management.service.AdminDashboardService;

@Service
public class AdminDashboardServiceImpl implements AdminDashboardService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AmountCollectionRepository amountCollectionRepository;

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

	@Override
	public Map<String, Object> getTotalIncomeList() {
		List<AmountCollections> allIncomeRecords = amountCollectionRepository.findAll().stream()
			    .filter(record -> "INCOME".equals(record.getType()))
			    .collect(Collectors.toList());
		
		 Map<String, BigDecimal> monthlyTotalIncome = new HashMap<>();

	     DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
	     for (AmountCollections record : allIncomeRecords) {
	            String monthKey = record.getDate().format(monthFormatter);  // Format the date as "yyyy-MM"
	            BigDecimal amount = record.getAmount();

	            // Add the amount to the existing total for this month (if any)
	            monthlyTotalIncome.put(monthKey, monthlyTotalIncome.getOrDefault(monthKey, BigDecimal.ZERO).add(amount));
	        }
	     List<Map<String, Object>> monthlyData = new ArrayList<>();
	     BigDecimal cumulativeTotal = BigDecimal.ZERO; // This will hold the cumulative total

	     for (Map.Entry<String, BigDecimal> entry : monthlyTotalIncome.entrySet()) {
	         Map<String, Object> monthData = new HashMap<>();
	         monthData.put("month", entry.getKey());  // The "yyyy-MM" formatted month
	         monthData.put("totalIncome", entry.getValue());  // The total income for that month

	         // Add the current month's total to the cumulative total
	         cumulativeTotal = cumulativeTotal.add(entry.getValue());
	         
	         monthlyData.add(monthData);
	     }

	     // Sort the monthly data by month (descending order)
	     monthlyData.sort((map1, map2) -> ((String) map2.get("month")).compareTo((String) map1.get("month")));

	     // Prepare cumulative total data
	     List<Map<String, Object>> cumulativeTotalData = new ArrayList<>();
	     Map<String, Object> cumulativeData = new HashMap<>();
	     cumulativeData.put("cumulativeTotal", cumulativeTotal);
	     cumulativeTotalData.add(cumulativeData);

	     // Data structure for response
	     Map<String, Object> data = new HashMap<>();
	     data.put("monthlyData", monthlyData);
	     data.put("cumulativeTotalData", cumulativeTotalData);

	     // Return data
	     return data;
	}

	@Override
	public Map<String, Object> getTotalExpenseList() {
		List<AmountCollections> allIncomeRecords = amountCollectionRepository.findAll().stream()
			    .filter(record -> "EXPENSE".equals(record.getType()))
			    .collect(Collectors.toList());
		
		 Map<String, BigDecimal> monthlyTotalIncome = new HashMap<>();

	     DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
	     for (AmountCollections record : allIncomeRecords) {
	            String monthKey = record.getDate().format(monthFormatter);  // Format the date as "yyyy-MM"
	            BigDecimal amount = record.getAmount();

	            // Add the amount to the existing total for this month (if any)
	            monthlyTotalIncome.put(monthKey, monthlyTotalIncome.getOrDefault(monthKey, BigDecimal.ZERO).add(amount));
	        }
	     List<Map<String, Object>> monthlyData = new ArrayList<>();
	     BigDecimal cumulativeTotal = BigDecimal.ZERO; // This will hold the cumulative total

	     for (Map.Entry<String, BigDecimal> entry : monthlyTotalIncome.entrySet()) {
	         Map<String, Object> monthData = new HashMap<>();
	         monthData.put("month", entry.getKey());  // The "yyyy-MM" formatted month
	         monthData.put("totalExpense", entry.getValue());  // The total income for that month

	         // Add the current month's total to the cumulative total
	         cumulativeTotal = cumulativeTotal.add(entry.getValue());
	         
	         monthlyData.add(monthData);
	     }

	     // Sort the monthly data by month (descending order)
	     monthlyData.sort((map1, map2) -> ((String) map2.get("month")).compareTo((String) map1.get("month")));

	     // Prepare cumulative total data
	     List<Map<String, Object>> cumulativeTotalData = new ArrayList<>();
	     Map<String, Object> cumulativeData = new HashMap<>();
	     cumulativeData.put("cumulativeTotal", cumulativeTotal);
	     cumulativeTotalData.add(cumulativeData);

	     // Data structure for response
	     Map<String, Object> data = new HashMap<>();
	     data.put("monthlyData", monthlyData);
	     data.put("cumulativeTotalData", cumulativeTotalData);

	     // Return data
	     return data;
	}

}
