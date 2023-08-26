package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.MasterLibrary;

@Repository
public interface MasterLibraryRepository extends JpaRepository<MasterLibrary, String>{

	public List<MasterLibrary> findByStatus(boolean b);

	@Query(value = "Select * from master_library where book_name = ?1", nativeQuery = true)
	public MasterLibrary findByBookName(String bookName);

	
	

}
