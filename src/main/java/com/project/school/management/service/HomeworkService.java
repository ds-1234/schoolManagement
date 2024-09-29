package com.project.school.management.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.school.management.entity.HomeworkEntity;
import com.project.school.management.request.HomeworkRequest;

public interface HomeworkService {

	HomeworkEntity saveHomework(HomeworkRequest homeworkRequest, MultipartFile file) throws IOException;

	List<HomeworkEntity> getHomeworkList();

}
