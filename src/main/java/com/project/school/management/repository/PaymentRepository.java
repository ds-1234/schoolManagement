package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.PaymentEntity;

import jakarta.transaction.Transactional;
@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{

	@Transactional
	@Query(value = "select * from payment_entity where user_table_id=:staffId and pay_period=:payPeriod", nativeQuery = true)
	List<PaymentEntity> findAllByUserTableIdAndPayPeriod(String staffId, String payPeriod);

}
