package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.PaymentEntity;
@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{

	List<PaymentEntity> findAllByUserTableId(Long staffId);

}
