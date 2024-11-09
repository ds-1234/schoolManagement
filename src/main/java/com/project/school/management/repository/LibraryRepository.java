package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.LibraryEntity;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {
	@Query(value ="SELECT COALESCE(MAX(e.id), 0) FROM library e", nativeQuery=true)
	Long findMaxId();

	List<LibraryEntity> findAllByOrderByIssuedDateDesc();

}
