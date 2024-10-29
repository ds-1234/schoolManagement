package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.WrokExperience;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WrokExperience, Long> {

	List<WrokExperience> findByTeacherId(String id);

}
