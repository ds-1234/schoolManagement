package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.UserLeaveCounterEntity;

@Repository
public interface LeaveCounterRepository extends JpaRepository<UserLeaveCounterEntity, Long>{

	List<UserLeaveCounterEntity> findAllByStaffId(Long staffId);

	UserLeaveCounterEntity findByStaffIdAndLeaveTypes(Long senderId, Long leaveType);

}
