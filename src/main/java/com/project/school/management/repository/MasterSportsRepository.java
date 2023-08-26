package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.MasterSports;

@Repository
public interface MasterSportsRepository extends JpaRepository<MasterSports, Object>{

	@Query(value = "Select * from master_sports where sports_name = ?1", nativeQuery = true)
	public MasterSports findBySportsName(String sportsName);

	@Query(value = "Select * from master_sports where status = ?1", nativeQuery = true)
	public List<MasterSports> findByStatus(boolean status);

	@Query(value = "Select * from master_sports where sports_id = ?1", nativeQuery = true)
	public MasterSports findBySportId(String sportsId);

}
