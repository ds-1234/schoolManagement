package com.project.school.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.Role;
import com.project.school.management.entity.UserEntity;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Object> {

	public List<Optional<UserEntity>> findByEmail(String email);

	public List<Optional<UserEntity>> findByPhone(String phone);

	public Optional<UserEntity> findByUserName(String userName);
	
	UserEntity findByUserId(String userId);

	Long countByRole(Role role);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user_entity SET academic_year = :promotedSession, class_name = :className WHERE id IN :userIds", nativeQuery = true)
	public void updateStudentPromotion(List<Long> userIds, String promotedSession, List<Long> className);

	//public void updateStudentPromotion(List<Long> userIds, String promotedSession, List<Long> className);

}
