package com.project.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.AmountCollections;


@Repository
public interface AmountCollectionRepository extends JpaRepository<AmountCollections, Long>{

}
