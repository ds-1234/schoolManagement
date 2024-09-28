package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.school.management.entity.HomeworkEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.HomeworkRepository;
import com.project.school.management.request.HomeworkRequest;
import com.project.school.management.service.HomeworkService;
import com.project.school.management.utility.Utils;

@Service
public class HomeworkServiceImpl implements HomeworkService {

	@Autowired
	private Utils utils;

	@Autowired
	private HomeworkRepository homeworkRepository;

	@Override
	public HomeworkEntity saveHomework(HomeworkRequest homeworkRequest, MultipartFile file) throws IOException {
		HomeworkEntity entity = new HomeworkEntity();
		if (Objects.isNull(homeworkRequest.getId())) {

			String generatedId = utils.generateRandomId();
			entity.setHomeworkId("HW" + generatedId);

			entity.setUser(homeworkRequest.getUser());
			entity.setClassName(homeworkRequest.getClassName());
			entity.setSubjectName(homeworkRequest.getSubjectName());
			entity.setHomeworkDate(homeworkRequest.getHomeworkDate());
			entity.setSubmissionDate(homeworkRequest.getSubmissionDate());

			String uploadedFile = utils.uploadFile(file);
			String [] name = uploadedFile.split(",");
//			int firstColon = uploadedFile.indexOf(':');
//			int secondColon = uploadedFile.indexOf(':', firstColon + 1);
			String fName = name[0];
			String fPath = name[1];
			entity.setAttachmentName(fName);
			entity.setAttachmentPath(fPath);
			entity.setIsActive(homeworkRequest.getIsActive());
			return this.homeworkRepository.save(entity);

		}
		Optional<HomeworkEntity> dbData = homeworkRepository.findById(homeworkRequest.getId());
		if (dbData.isEmpty()) {
			throw new InvalidArgumentException("Given id is invalid or empty");
		}
		HomeworkEntity data = dbData.get();
		data.setClassName(homeworkRequest.getClassName());
		data.setSubjectName(homeworkRequest.getSubjectName());
		data.setHomeworkDate(homeworkRequest.getHomeworkDate());
		data.setSubmissionDate(homeworkRequest.getSubmissionDate());

		String uploadedFile = utils.uploadFile(file);
		int firstColon = uploadedFile.indexOf(':');
		int secondColon = uploadedFile.indexOf(':', firstColon + 1);
		String fName = uploadedFile.substring(firstColon + 1);
		String fPath = uploadedFile.substring(secondColon + 1);
		data.setAttachmentName(fName);
		data.setAttachmentPath(fPath);
		data.setIsActive(homeworkRequest.getIsActive());

		return this.homeworkRepository.save(data);
	}
}
