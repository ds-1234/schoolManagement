package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.TeacherInfoEntity;

@Repository
public interface TeacherInfoRepository extends JpaRepository<TeacherInfoEntity, Long> {

	TeacherInfoEntity findByTeacherId(String id);

}
