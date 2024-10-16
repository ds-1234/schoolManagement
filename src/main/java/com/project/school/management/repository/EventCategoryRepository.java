package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.EventCategoryEntity;
@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategoryEntity, Long>{

	@Query(value ="SELECT COALESCE(MAX(e.id), 0) FROM event_category e", nativeQuery=true)
	Long findMaxId();

}
