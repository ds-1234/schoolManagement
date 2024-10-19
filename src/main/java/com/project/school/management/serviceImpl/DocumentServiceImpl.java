package com.project.school.management.serviceImpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.school.management.entity.DocumentEntity;
import com.project.school.management.entity.UserEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.DocumentRepository;
import com.project.school.management.repository.UserRepository;
import com.project.school.management.service.DocumentService;
import com.project.school.management.utility.Utils;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private Utils utils;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveDocument(MultipartFile[] files, String id) {
		try {
			for(MultipartFile file : files) {
				DocumentEntity documentEntity = new DocumentEntity();
				String uploadedFile = utils.uploadFile(file);
				String [] name = uploadedFile.split(",");
				String fName = name[0];
				String fPath = name[1];
				documentEntity.setAttachmentName(fName);
				documentEntity.setAttachmentPath(fPath);
				documentEntity.setIsActive(true);
				documentEntity.setUserId(id);
				UserEntity userData = userRepository.findByUserId(id);
				if(Objects.isNull(userData)) {
					throw new InvalidArgumentException("given id is invalid");
				}
				userData.setIsActive(true);
				userRepository.save(userData);
				this.documentRepository.save(documentEntity);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
