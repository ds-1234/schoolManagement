package com.project.school.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Object>{

	@Query(value = "Select u from user_entity u where (LOWER(email) = LOWER(?1))", nativeQuery = true)
	public Optional<UserEntity> findByEmail(String email);

	@Query(value = "Select u from user_entity u where phone = ?1", nativeQuery = true)
	public Optional<UserEntity> findByPhone(Long phone);

	@Query(value = "Select * from user_entity where (LOWER(email) = LOWER(?1))", nativeQuery = true)
	public Optional<UserEntity> getUserByEmail(String email);

	@Query(value = "Select * from user_entity where phone = ?1", nativeQuery = true)
	public Optional<UserEntity> getUserByPhone(Long phone);

	@Query(value = "Select * from user_entity where user_name = ?1", nativeQuery = true)
	public Optional<UserEntity> findByUserName(String userName);


}
