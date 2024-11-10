package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.StaffAttendanceStatusEntity;

@Repository
public interface StaffAttendanceStatusRepository extends JpaRepository<StaffAttendanceStatusEntity, Long>{

	@Query(value ="SELECT COALESCE(MAX(e.id), 0) FROM staff_attendance_status e", nativeQuery=true)
	Long findMaxId();

}
