package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.ExamResultEntity;
@Repository
public interface ExamResultRepository extends JpaRepository<ExamResultEntity, Long>{

	List<ExamResultEntity> findAllByTeacherId(Long teacherId);

	List<ExamResultEntity> findAllByStudentId(Long studentId);

}
