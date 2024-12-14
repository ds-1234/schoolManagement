package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.ExamResultEntity;
import com.project.school.management.response.ExamResultResponseForAdmin;

import jakarta.persistence.Tuple;
@Repository
public interface ExamResultRepository extends JpaRepository<ExamResultEntity, Long>{

	@Query(value = "select * from exam_result where teacher_id=:teacherId AND exam_type=:examType AND class_name=:className", nativeQuery = true)
	ExamResultEntity findByTeacherIdAndExamTypeIdAndClassName(Long teacherId, Long examType, Long className);

	@Query(value = "SELECT ue.first_name, ue.last_name, s.subject, sm.exam_marks, sm.remarks " +
            "FROM exam_result er " +
            "JOIN subject s ON er.subject_id = s.id " +
            "JOIN student_marks sm ON er.id = sm.exam_result_id " +
            "JOIN user_entity ue ON sm.student_id = ue.id " +
            "WHERE er.class_name = :className AND er.exam_type = :examType", 
            nativeQuery = true)
List<Tuple> findStudentResults(Long className, Long examType);



}
