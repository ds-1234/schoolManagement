package com.project.school.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Object>{

	public List<Optional<UserEntity>> findByEmail(String email);

	public List<Optional<UserEntity>> findByPhone(Long phone);

	//public Optional<UserEntity> getUserByEmail(String email);

	//public Optional<UserEntity> getUserByPhone(Long phone);

	public Optional<UserEntity> findByUserName(String userName);


}
