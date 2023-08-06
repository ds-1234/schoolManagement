package com.project.school.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.GradeEntity;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Object>{

	Optional<GradeEntity> getByGrade(String grade);

}
