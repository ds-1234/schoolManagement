package com.project.school.management.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.BloodGroupEntity;
import com.project.school.management.entity.GenderEntity;
import com.project.school.management.entity.GradeEntity;
import com.project.school.management.entity.GradeSectionEntity;
import com.project.school.management.entity.MasterHoliday;
import com.project.school.management.entity.RoleEntity;
import com.project.school.management.request.SubjectRequest;
import com.project.school.management.service.MasterService;

@RestController
@RequestMapping("/master")
public class MasterController {
	
	private static final Logger log = LoggerFactory.getLogger(MasterController.class);
	
	@Autowired
	private MasterService masterService;
	
	@PostMapping("/addRole")
	public ResponseEntity<Object> addRole(@RequestBody RoleEntity roleEntity) throws IOException{
		log.info("******  API Start For save role******");
				return masterService.saveRole(roleEntity);	
	}
	
	@GetMapping("/getRole")
	public ResponseEntity<Object> getRole() throws IOException{
		log.info("******  API Start For get role******");
				return masterService.getRole();	
	}
	
	@PostMapping("/addGrade")
	public ResponseEntity<Object> addGrade(@RequestBody GradeEntity gradeEntity) throws IOException{
		log.info("******  API Start For save grade******");
				return masterService.saveGrade(gradeEntity);	
	}
	
	@GetMapping("/getGrade")
	public ResponseEntity<Object> getGrade() throws IOException{
		log.info("******  API Start For get grade******");
				return masterService.getGrade();	
	}
	
	@PostMapping("/addGradeSection")
	public ResponseEntity<Object> addGradeSection(@RequestBody GradeSectionEntity gradeSecEntity) throws IOException{
		log.info("******  API Start For save grade section******");
				return masterService.saveGradeSection(gradeSecEntity);	
	}
	
	@GetMapping("/getGradeSection")
	public ResponseEntity<Object> getGradeSection() throws IOException{
		log.info("******  API Start For get grade section******");
				return masterService.getGradeSection();	
	}
	
	@PostMapping("/addGender")
	public ResponseEntity<Object> addGender(@RequestBody GenderEntity genderEntity) throws IOException{
		log.info("******  API Start For save gender******");
				return masterService.saveGender(genderEntity);	
	}
	
	@GetMapping("/getGender")
	public ResponseEntity<Object> getGender() throws IOException{
		log.info("******  API Start For get gender******");
				return masterService.getGender();	
	}
	
	@PostMapping("/addBloodGroup")
	public ResponseEntity<Object> addBloodGroup(@RequestBody BloodGroupEntity bloodGroupEntity) throws IOException{
		log.info("******  API Start For save blood group******");
				return masterService.saveBloodGroup(bloodGroupEntity);	
	}
	
	@GetMapping("/getBloodGroup")
	public ResponseEntity<Object> getBloodGroup() throws IOException{
		log.info("******  API Start For get blood group******");
				return masterService.getBloodGroup();	
	}
	
	@PostMapping("/addSubject")
	public ResponseEntity<Object> addSubject(@RequestBody SubjectRequest subjectRequest) throws IOException{
		log.info("******  API Start For save subject******");
				return masterService.saveSubject(subjectRequest);	
	}
	
	@GetMapping("/getSubject")
	public ResponseEntity<Object> getSubject() throws IOException{
		log.info("******  API Start For get subject******");
				return masterService.getSubject();	
	}
	
	@PostMapping("/addHoliday")
	public ResponseEntity<Object> addHoliday(@RequestBody MasterHoliday masterHoliday) throws IOException{
		log.info("******  API Start For save master holiday******");
				return masterService.saveHoliday(masterHoliday);	
	}
	
	@GetMapping("/getHoliday")
	public ResponseEntity<Object> getHoliday() throws IOException{
		log.info("******  API Start For get master holiday******");
				return masterService.getHoliday();	
	}

}
