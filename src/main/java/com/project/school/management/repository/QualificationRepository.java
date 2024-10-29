package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {

	List<Qualification> findByTeacherId(String id);

}
