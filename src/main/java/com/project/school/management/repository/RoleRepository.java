package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByNameIgnoreCase(String name);

}
