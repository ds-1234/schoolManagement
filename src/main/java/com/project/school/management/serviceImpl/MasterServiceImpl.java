package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.BloodGroupEntity;
import com.project.school.management.entity.GenderEntity;
import com.project.school.management.entity.GradeEntity;
import com.project.school.management.entity.GradeSectionEntity;
import com.project.school.management.entity.MasterHoliday;
import com.project.school.management.entity.RoleEntity;
import com.project.school.management.entity.SubjectEntity;
import com.project.school.management.exception.FieldAlreadyExist;
import com.project.school.management.exception.InvalidRoleException;
import com.project.school.management.repository.BloodGroupRepository;
import com.project.school.management.repository.GenderRepository;
import com.project.school.management.repository.GradeRepository;
import com.project.school.management.repository.GradeSectionRepository;
import com.project.school.management.repository.MasterHolidayRepository;
import com.project.school.management.repository.RoleRepository;
import com.project.school.management.repository.SubjectRepository;
import com.project.school.management.request.SubjectRequest;
import com.project.school.management.response.ResponseHandler;
import com.project.school.management.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {

	private static final Logger log = LoggerFactory.getLogger(MasterServiceImpl.class);

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private GradeSectionRepository gradeSectionRepository;

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private BloodGroupRepository bloodGroupRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private MasterHolidayRepository masterHolidayRepository;

	@Override
	public ResponseEntity<Object> saveRole(RoleEntity roleEntity) throws IOException {
		log.info("Inside save role method");
		HashMap<String, Object> map = new LinkedHashMap<>();
		if (roleRepository.getByRole(roleEntity.getRole()).isPresent()) {
			throw new InvalidRoleException();
		}
		roleRepository.save(roleEntity);
		map.put("role", roleEntity.getRole());
		map.put("description", roleEntity.getDescription());
		log.info("role added sucessfully");
		return ResponseHandler.generateResponse("SUCCESS: Role added successfully", HttpStatus.OK, "", map);
	}

	@Override
	public ResponseEntity<Object> getRole() {
		log.info("Inside get Role ");
		List<RoleEntity> role = roleRepository.findAll();
		return ResponseHandler.generateResponse("SUCCESS: Get Role", HttpStatus.OK, "", role);
	}

	@Override
	public ResponseEntity<Object> saveGrade(GradeEntity gradeEntity) throws IOException {
		log.info("Inside save grade method");
		if (gradeRepository.getByGrade(gradeEntity.getGrade()).isPresent()) {
			throw new FieldAlreadyExist();
		}
		gradeRepository.save(gradeEntity);
		log.info("grade added sucessfully");
		return ResponseHandler.generateResponse("Grade added successfully", HttpStatus.OK, "", "Success");
	}

	@Override
	public ResponseEntity<Object> saveGradeSection(GradeSectionEntity gradeSecEntity) {
		log.info("Inside save grade section method");
		if (gradeSectionRepository.getByGradeSection(gradeSecEntity.getGradeSection()).isPresent()) {
			throw new FieldAlreadyExist();
		}
		GradeSectionEntity sec = new GradeSectionEntity();
		sec.setGradeSection(gradeSecEntity.getGradeSection().toUpperCase());
		gradeSectionRepository.save(sec);
		log.info("Grade section added sucessfully");
		return ResponseHandler.generateResponse("Grade section added sucessfully", HttpStatus.OK, "", "Success");
	}

	@Override
	public ResponseEntity<Object> getGradeSection() throws IOException {
		log.info("Inside get grade section method");
		List<GradeSectionEntity> section = gradeSectionRepository.findAll();
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", section);
	}

	@Override
	public ResponseEntity<Object> getGrade() throws IOException {
		log.info("Inside get grade method");
		List<GradeEntity> grade = gradeRepository.findAll();
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", grade);
	}

	@Override
	public ResponseEntity<Object> saveGender(GenderEntity genderEntity) throws IOException {
		log.info("Inside save gender method");
		if (genderRepository.getByGender(genderEntity.getGender().toUpperCase()).isPresent()) {
			throw new FieldAlreadyExist();
		}
		GenderEntity gender = new GenderEntity();
		gender.setGender(genderEntity.getGender().toUpperCase());
		genderRepository.save(gender);
		log.info("Gender added successfully");
		return ResponseHandler.generateResponse("Gender added successfully", HttpStatus.OK, "", "Success");
	}

	@Override
	public ResponseEntity<Object> saveBloodGroup(BloodGroupEntity bloodGroupEntity) throws IOException {
		log.info("Inside save blood group method");
		if (bloodGroupRepository.getByBloodGroup(bloodGroupEntity.getBloodGroup().toUpperCase()).isPresent()) {
			throw new FieldAlreadyExist();
		}
		BloodGroupEntity bloodGroup = new BloodGroupEntity();
		bloodGroup.setBloodGroup(bloodGroupEntity.getBloodGroup().toUpperCase());
		bloodGroupRepository.save(bloodGroup);
		log.info("Blood Group added successfully");
		return ResponseHandler.generateResponse("Blood Group added successfully", HttpStatus.OK, "", "Success");
	}

	@Override
	public ResponseEntity<Object> getGender() throws IOException {
		log.info("Inside get gender method");
		List<GenderEntity> gender = genderRepository.findAll();
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", gender);
	}

	@Override
	public ResponseEntity<Object> getBloodGroup() throws IOException {
		log.info("Inside get blood group method");
		List<BloodGroupEntity> blood = bloodGroupRepository.findAll();
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", blood);
	}

	@Override
	public ResponseEntity<Object> saveSubject(SubjectRequest subjectRequest) throws IOException {
		log.info("inside add subjet method");
		if (subjectRepository.getBySubject(subjectRequest.getSubject().toUpperCase()).isPresent()) {
			throw new FieldAlreadyExist();
		}
		SubjectEntity subjectEntity = new SubjectEntity();
		subjectEntity.setSubject(subjectRequest.getSubject().toUpperCase());
		subjectEntity.setDescription(subjectRequest.getDescription());
		String subjectId = generateRandom();
		String number = subjectRequest.getSubject().substring(0, 3).toUpperCase() + subjectId;
		subjectEntity.setSubjectId(number);
		subjectRepository.save(subjectEntity);
		log.info("Subject added successfully");
		return ResponseHandler.generateResponse("Subject added successfully", HttpStatus.OK, "", "Success");
	}

	private String generateRandom() {
		Random random = new Random();
		int num = random.nextInt(100, 999);
		String strNum = String.valueOf(num);
		return strNum;
	}

	@Override
	public ResponseEntity<Object> getSubject() throws IOException {
		log.info("Inside get subject method");
		List<SubjectEntity> subject = subjectRepository.findAll();
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", subject);
	}

	@Override
	public ResponseEntity<Object> saveHoliday(MasterHoliday masterHoliday) throws IOException {
		log.info("++++inside add master holiday method+++");
		MasterHoliday holiday = masterHolidayRepository.findOne(masterHoliday.getMasterHolidayName());
		System.out.println("holiday: " + holiday);
		if (holiday != null) {
			log.info("++++holiday exist in master+++");
			throw new FieldAlreadyExist();
		}
		log.info("++call generateHolidayId function+++");
		String holidayId = generateHolidayId(masterHoliday);
		masterHoliday.setHolidayAssignId(holidayId);
		masterHoliday.setStatus(true);
		masterHolidayRepository.save(masterHoliday);
		log.info("++master holiday data successfully saves+++");
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", masterHoliday);
	}

	private String generateHolidayId(MasterHoliday masterHoliday) {
		log.info("inside generate holiday id");
		String strng = masterHoliday.getMasterHolidayName().substring(0, 3);
		String randNumber = generateRandom();
		String id = "HDAY" + strng.toUpperCase() + randNumber;
		return id;
	}

	@Override
	public ResponseEntity<Object> getHoliday() throws IOException {
		log.info("Inside get holiday method");
		List<MasterHoliday> holiday = masterHolidayRepository.findByStatus(true);
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", holiday);
	}

}
