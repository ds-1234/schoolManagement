package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.StateEntity;
@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long>{

	List<StateEntity> findByCountryId(Long id);

}
