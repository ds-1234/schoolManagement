package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.MasterHoliday;
@Repository
public interface MasterHolidayRepository extends JpaRepository<MasterHoliday, Integer>{

	@Query(value = "Select * from master_holiday where master_holiday_name = ?1", nativeQuery = true)
	MasterHoliday findOne(String masterHolidayName);

//	@Query(value = "Select * from master_holiday where status = ?1", nativeQuery = true)
//	List<MasterHoliday> findAllAndActive(Boolean active);

	List<MasterHoliday> findByStatus(boolean status);

	
	

}
