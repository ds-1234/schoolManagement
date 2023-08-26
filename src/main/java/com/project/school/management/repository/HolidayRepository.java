package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.HolidayEntity;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, Integer>{

	List<HolidayEntity> findByStatus(boolean status);

}
