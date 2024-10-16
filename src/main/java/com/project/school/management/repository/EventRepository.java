package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.EventEntity;
@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long>{

	@Query(value ="SELECT COALESCE(MAX(e.id), 0) FROM events e", nativeQuery=true)
	Long findMaxId();

}
