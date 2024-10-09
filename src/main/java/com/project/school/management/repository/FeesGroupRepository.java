package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.FeesGroupEntity;
@Repository
public interface FeesGroupRepository extends JpaRepository<FeesGroupEntity, Long>{
	
	@Query(value ="SELECT COALESCE(MAX(e.id), 0) FROM fees_group e", nativeQuery=true)
	Long findMaxId();

}
