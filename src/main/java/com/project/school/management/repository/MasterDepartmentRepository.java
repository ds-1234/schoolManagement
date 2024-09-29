package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.MasterDepartmentEntity;
@Repository
public interface MasterDepartmentRepository extends JpaRepository<MasterDepartmentEntity, Long>{

}
