package com.project.school.management.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.EventEntity;
@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long>{

	@Query(value ="SELECT COALESCE(MAX(e.id), 0) FROM events e", nativeQuery=true)
	Long findMaxId();

	@Query(value ="select * from events where event_category=:catId", nativeQuery=true)
	List<EventEntity> findByCatId(Long catId);
	
	@Query(value= "Select * from events where EXTRACT(MONTH FROM start_date)=:month and \r\n"
			+ "EXTRACT(YEAR FROM start_date)=:year", nativeQuery = true)
	List<EventEntity> findByMonthAndYear(@Param("month") int month, @Param("year") int year);

	@Query(value ="Select * from events where start_date BETWEEN :stDate and :enDate", nativeQuery=true)
	List<EventEntity> findByWeek(@Param("stDate") LocalDate stDate, @Param("enDate")LocalDate enDate);

	@Query(value ="Select * from events where start_date =:date", nativeQuery=true)
	List<EventEntity> findByDate(LocalDate date);

	

}
