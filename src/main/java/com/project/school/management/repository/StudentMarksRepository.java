package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.StudentMarksEntity;
@Repository
public interface StudentMarksRepository extends JpaRepository<StudentMarksEntity, Long>{

	@Query(value = "select * from student_marks", nativeQuery = true)
	List<StudentMarksEntity> findAllByExamResultId(Long id);


}
