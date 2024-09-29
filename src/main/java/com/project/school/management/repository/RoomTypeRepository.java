package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.RoomTypeEntity;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Long>{

}
