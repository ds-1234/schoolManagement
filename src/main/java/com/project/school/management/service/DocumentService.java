package com.project.school.management.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

	void saveDocument(MultipartFile[] files, String id);

}
