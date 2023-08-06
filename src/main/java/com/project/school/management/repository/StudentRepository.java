package com.project.school.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Object>{

	@Query(value = "Select * from student_entity where first_name = ?1", nativeQuery = true)
	public Optional<StudentEntity> findByFirstName(String firstName);

	@Query(value = "Select * from student_entity where admission_id = ?1", nativeQuery = true)
	public StudentEntity findByAdmissionId(String admissionId);

}
