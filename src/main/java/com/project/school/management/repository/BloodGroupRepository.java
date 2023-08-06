package com.project.school.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.BloodGroupEntity;

@Repository
public interface BloodGroupRepository extends JpaRepository<BloodGroupEntity, Object> {

	@Query(value = "Select * from master_blood_group where blood_group = ?1", nativeQuery = true)
	Optional<BloodGroupEntity> getByBloodGroup(String bloodGroup);

}
