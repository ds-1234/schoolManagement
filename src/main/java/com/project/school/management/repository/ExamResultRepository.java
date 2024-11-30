package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.ExamResultEntity;
@Repository
public interface ExamResultRepository extends JpaRepository<ExamResultEntity, Long>{

	@Query(value = "select * from exam_result where teacher_id=:teacherId AND exam_type=:examType AND class_name=:className", nativeQuery = true)
	ExamResultEntity findByTeacherIdAndExamTypeIdAndClassName(Long teacherId, Long examType, Long className);

//	List<ExamResultEntity> findAllByStudentId(Long studentId);

}
