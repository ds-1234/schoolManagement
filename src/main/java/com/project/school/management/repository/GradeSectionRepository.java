package com.project.school.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.GradeSectionEntity;

@Repository
public interface GradeSectionRepository extends JpaRepository<GradeSectionEntity, Object>{

	@Query(value = "Select * from master_grade_section where grade_section = ?1", nativeQuery = true)
	public Optional<GradeSectionEntity> getByGradeSection(String gradeSection);

}
