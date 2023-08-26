package com.project.school.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.StudentEntity;
import com.project.school.management.response.MaleFemaleStudentResponse;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Object>{

	@Query(value = "Select * from student_entity where first_name = ?1", nativeQuery = true)
	public Optional<StudentEntity> findByFirstName(String firstName);

	@Query(value = "Select * from student_entity where admission_id = ?1", nativeQuery = true)
	public StudentEntity findByAdmissionId(String admissionId);

//	@Query(value = "SELECT\r\n"
//			+ "    COUNT(CASE WHEN gender = ?1 THEN 1 END) AS male_count,\r\n"
//			+ "    COUNT(CASE WHEN gender = ?2 THEN 1 END) AS female_count\r\n"
//			+ "FROM student_entity", nativeQuery = true)
//	public MaleFemaleStudentResponse countOnBaissOfGender(String string, String string2);

	@Query(value = "Select gender from student_entity", nativeQuery = true)
	public List<String> countOnBaissOfGender();

}
