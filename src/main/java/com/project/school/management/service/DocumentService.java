package com.project.school.management.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.school.management.entity.DocumentEntity;

public interface DocumentService {

	void saveDocument(MultipartFile[] files, String id);
	
	List<DocumentEntity> getDocument(String id);

}
