package com.project.school.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.SubjectEntity;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Object>{

	@Query(value = "Select * from master_subject where subject = ?1", nativeQuery = true)
	public Optional<SubjectEntity> getBySubject(String subject);

}
