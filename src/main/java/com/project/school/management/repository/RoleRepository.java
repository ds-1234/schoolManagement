package com.project.school.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Object>{

	@Query(value = "Select * from master_role where role = ?1", nativeQuery = true)
	public Optional<RoleEntity> getByRole(String role);

}
