package com.project.school.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.GenderEntity;

@Repository
public interface GenderRepository extends JpaRepository<GenderEntity, Object>{

	@Query(value = "Select * from master_gender where gender = ?1", nativeQuery = true)
	public Optional<GenderEntity> getByGender(String gender);

}
