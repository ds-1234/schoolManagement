package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.school.management.response.ExamResultResponseForAdmin;

@Repository
public interface CustomRepository {

//	@Query(value = "SELECT \r\n"
//			+ "ue.first_name, ue.last_name, s.subject, sm.exam_marks, sm.remarks \r\n"
//			+ "FROM exam_result er \r\n"
//			+ "JOIN subject s ON er.subject_id = s.id \r\n"
//			+ "JOIN student_marks sm ON er.id = sm.exam_result_id \r\n"
//			+ "JOIN user_entity ue ON sm.student_id = ue.id \r\n"
//			+ "WHERE er.class_name =:className AND er.exam_type =:examType", nativeQuery = true)
//	List<ExamResultResponseForAdmin> findStudentResults(@Param("className") Long className, @Param("examType")Long examType);

}
