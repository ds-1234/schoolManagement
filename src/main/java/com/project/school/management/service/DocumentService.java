package com.project.school.management.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.school.management.dto.IdDto;
import com.project.school.management.entity.DocumentEntity;

public interface DocumentService {

	void saveDocument(MultipartFile file,String filesName, String id,String moduleName,Long moduleId);
	
	List<DocumentEntity> getDocument(String id);

	void deleteDocument(IdDto id);

}
