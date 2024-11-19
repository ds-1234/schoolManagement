package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.ClassSubjectEntity;

@Repository
public interface ClassSubjectRepository extends JpaRepository<ClassSubjectEntity, Long> {

	List<ClassSubjectEntity> findByTeacherId(String id);

}
