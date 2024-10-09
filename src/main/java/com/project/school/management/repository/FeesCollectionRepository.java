package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.FeesCollectionEntity;
@Repository
public interface FeesCollectionRepository extends JpaRepository<FeesCollectionEntity, Long>{

	@Query(value ="SELECT COALESCE(MAX(e.id), 0) FROM fees_collection e", nativeQuery=true)
	Long findMaxId();

}
