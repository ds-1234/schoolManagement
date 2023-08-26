package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.school.management.exception.DataNotExist;
import com.project.school.management.repository.StudentRepository;
import com.project.school.management.response.MaleFemaleStudentResponse;
import com.project.school.management.response.ResponseHandler;
import com.project.school.management.service.AdminDashService;
@Service
public class AdminDashServiceImpl implements AdminDashService{
	
	private static final Logger log = LoggerFactory.getLogger(AdminDashServiceImpl.class);
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public ResponseEntity<Object> getStudent(String role) throws IOException {
		log.info("++inside get student method++");
		try {
			log.info("++inside try and go to check role++");
			if(role.equalsIgnoreCase("admin")) {
				Long student = studentRepository.count();
				log.info("++api successfully get number of students++");
				return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", student);
			}
			log.error("++invalid role++");
			return ResponseHandler.generateResponse("NOT SUCCESS", HttpStatus.BAD_REQUEST, "Invalid Request", "");
		}catch(Exception e) {
			log.error("++bad request, data not found++");
			throw new DataNotExist("Invalid Request, Data not found");
		}
		
	}

	@Override
	public ResponseEntity<Object> getBoysAndGirls(String role) throws IOException {
		log.info("++inside get boys and girls method++");
		try {
			
			log.info("++inside try and go to check role++");
			if(role.equalsIgnoreCase("admin")) {
				List<String> studentData = studentRepository.countOnBaissOfGender();
				System.out.println("studentData: "+studentData);
				for(String gender: studentData) {
					MaleFemaleStudentResponse student = new MaleFemaleStudentResponse();
//					student.setFemaleCount(gender.equalsIgnoreCase("FEMALE"));
//					(gender.equalsIgnoreCase("MALE"))
				}
				log.info("++api successfully get number of students++");
				return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", studentData);
			}
			log.error("++invalid role++");
			return ResponseHandler.generateResponse("NOT SUCCESS", HttpStatus.BAD_REQUEST, "Invalid Request", "");
		}catch(Exception e) {
			log.error("++bad request, data not found++");
			throw new DataNotExist("Invalid Request, Data not found");
		}
	}

}
