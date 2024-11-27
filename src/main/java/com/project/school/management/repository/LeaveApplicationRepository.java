package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.LeaveApplicationEntity;
@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplicationEntity, Long>{

}
