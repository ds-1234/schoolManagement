package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.CitiesEntity;
@Repository
public interface CitiesRepository extends JpaRepository<CitiesEntity, Long>{

	List<CitiesEntity> findByStateId(Long id);

}
