package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.StaffAttendanceEntity;
@Repository
public interface StaffAttendanceRepository extends JpaRepository<StaffAttendanceEntity, Long>{

	@Query(value ="SELECT COALESCE(MAX(e.id), 0) FROM staff_attendance e", nativeQuery=true)
	Long findMaxId();

}
