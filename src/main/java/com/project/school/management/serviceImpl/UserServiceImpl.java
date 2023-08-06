package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.BloodGroupEntity;
import com.project.school.management.entity.GenderEntity;
import com.project.school.management.entity.GradeEntity;
import com.project.school.management.entity.GradeSectionEntity;
import com.project.school.management.entity.RoleEntity;
import com.project.school.management.entity.StudentEntity;
import com.project.school.management.entity.UserEntity;
import com.project.school.management.exception.InvalidRoleException;
import com.project.school.management.exception.UserAlreadyExistException;
import com.project.school.management.repository.BloodGroupRepository;
import com.project.school.management.repository.GenderRepository;
import com.project.school.management.repository.GradeRepository;
import com.project.school.management.repository.GradeSectionRepository;
import com.project.school.management.repository.RoleRepository;
import com.project.school.management.repository.StudentRepository;
import com.project.school.management.repository.UserRepository;
import com.project.school.management.request.AddStudentRequest;
import com.project.school.management.request.LoginRequest;
import com.project.school.management.request.UserRequest;
import com.project.school.management.response.ResponseHandler;
import com.project.school.management.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private GenderRepository genderRepository;
	
	@Autowired
	private BloodGroupRepository bloodGroupRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private GradeSectionRepository gradeSectionRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseEntity<Object> saveUserDetail(UserRequest userRequest) throws IOException{
		if(userRepository.getUserByEmail(userRequest.getEmail()).isPresent()){
			log.error("User already exist with email exception raised");
            throw new UserAlreadyExistException("User Already exist with email and one of the existing role");
		}
		else if(userRepository.getUserByPhone(userRequest.getPhone()).isPresent()) {
			log.error("User already exist with phone exception raised");
            throw new UserAlreadyExistException("User Already exist with phone and one of the existing role");
		}else {
			UserEntity user = new UserEntity();
			BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
			
			log.info("call function generateUserName");
			String username = generateUserName(userRequest.getEmail(), userRequest.getPhone());
			user.setUserName(username);
			
			RoleEntity role = roleRepository.findById(userRequest.getRole()).get();
			if(role.getRole().equalsIgnoreCase("Teacher")) {
				String teacherId = generateTeacherId(userRequest.getPhone());
				user.setTeacherId(teacherId);
			}
			user.setRole(role.getRole());
			
			user.setEmail(userRequest.getEmail());
			user.setPassword(bCrypt.encode(userRequest.getPassword())); 
			user.setPhone(userRequest.getPhone());
			
			log.info("User save");
			userRepository.save(user);
			return ResponseHandler.generateResponse("Success: User Save", HttpStatus.OK, null, user) ;
		}
		
	}

	private String generateTeacherId(Long phone) {
		String sanitizedPhoneNumber = sanitizeString(String.valueOf(phone));
        String contact = sanitizedPhoneNumber.substring(sanitizedPhoneNumber.length() - 4);
		String teachId = "TEACH" + contact;
		return teachId;
	}

	//method to generateUserName
	private String generateUserName(String email, Long phone) {
		log.info("inside method generateUserName and call sanitizeString function");
		
		String[] parts = email.split("@");
		
        String sanitizedPhoneNumber = sanitizeString(String.valueOf(phone));
        String contact = sanitizedPhoneNumber.substring(sanitizedPhoneNumber.length() - 4);
        
     // Concatenate the sanitized email and phone number
        log.info("concatenate email and phone");
        String concatenatedString = parts[0] + contact;
        
		return concatenatedString;
	}


	private String sanitizeString(String input) {
		log.info("inside sanitizeString method");
		 return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

	@Override
	public ResponseEntity<Object> login(LoginRequest loginRequest) throws IOException {
		HashMap<String, Object> map = new LinkedHashMap<>();
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();	
		var roleName = roleRepository.findById(loginRequest.getRole()).get();
		if(loginRequest.getEmail()!=null && loginRequest.getRole()!=null) {
			log.info("login by email");
			Optional<UserEntity> opUser = userRepository.getUserByEmail(loginRequest.getEmail());
			if(opUser.isPresent()) {
				UserEntity dbUser = opUser.get();
				if(dbUser.getRole().equals(roleName.getRole()) && bCrypt.matches(loginRequest.getPassword(), dbUser.getPassword())) {
					log.info("login successfully by email");
					map.put("email", loginRequest.getEmail());
					map.put("role", roleName.getRole());
					return ResponseHandler.generateResponse("Success : User Login Successfully", HttpStatus.OK, null, map);
				}
			}
		}else if(loginRequest.getUserName()!=null && loginRequest.getRole()!=null) {
			log.info("login by username");
			Optional<UserEntity> opUser = userRepository.findByUserName(loginRequest.getUserName());
			if(opUser.isPresent()) {
				UserEntity dbUser = opUser.get();
				if(dbUser.getRole().equals(roleName.getRole()) && bCrypt.matches(loginRequest.getPassword(), dbUser.getPassword())) {
					log.info("login successfully by username");
					map.put("userName", loginRequest.getUserName());
					map.put("role", roleName.getRole());
					return ResponseHandler.generateResponse("Success : User Login Successfully", HttpStatus.OK, null, map);
				}
			}
		}
		
		return ResponseHandler.generateResponse("Not Success", HttpStatus.BAD_REQUEST, "User Not Exist", "");
	}
	
	@Override
	public ResponseEntity<Object> saveStudentDetail(AddStudentRequest request) throws IOException {
		log.info("inside save student method");
			StudentEntity entity = new StudentEntity();
			StudentEntity admId = studentRepository.findByAdmissionId(request.getAdmissionId());
			if(admId!=null) {
					log.info("Student Already exist with this admission id: "+request.getAdmissionId());
					throw new UserAlreadyExistException("Student Already exist with admission id");

			}else{
				String nameStId = request.getFirstName().substring(0, 3);
				String phoneString = String.valueOf(request.getParentsContact());
				String phoneStId = phoneString.substring(0, 4);
				String gradeString = String.valueOf(request.getGrade());
				String gradeStId = gradeString;
				String stId = nameStId + phoneStId + gradeStId;
				
				GenderEntity gender = genderRepository.findById(request.getGender())
						.orElseThrow(() -> new IllegalArgumentException("Invalid gender_id"));
				log.info("set gender");
				entity.setGender(gender.getGender());
				
				BloodGroupEntity blood = bloodGroupRepository.findById(request.getBloodGroup())
						.orElseThrow(() -> new IllegalArgumentException("Invalid blood_group_id"));
				log.info("set blood group");
				entity.setBloodGroup(blood.getBloodGroup());
				
				GradeEntity grade = gradeRepository.findById(request.getGrade())
						.orElseThrow(() -> new IllegalArgumentException("Invalid grade_id"));
				log.info("set grade");
				entity.setGrade(grade.getGrade());
				
				GradeSectionEntity gradeSec = gradeSectionRepository.findById(request.getGradeSection())
						.orElseThrow(() -> new IllegalArgumentException("Invalid grade_section_id"));
				log.info("set section");
				entity.setGradeSection(gradeSec.getGradeSection());
				
				entity.setFirstName(request.getFirstName());
				entity.setLastName(request.getLastName());
				entity.setEmail(request.getEmail());
				entity.setAddress(request.getAddress());
				entity.setParentsContact(request.getParentsContact());
				entity.setAdmissionId(request.getAdmissionId());
				entity.setDateOfBirth(request.getDateOfBirth());
				entity.setStudentId(stId);
				log.info("store data into entity ");
				studentRepository.save(entity);
				log.info("Student successfully added");
				
			}
			return ResponseHandler.generateResponse("Success: Student save successfully", HttpStatus.OK, null, entity);
	}

	@Override
	public ResponseEntity<Object> getStudent() throws IOException {
		log.info("inside get dtudent method");
		List<StudentEntity> list = studentRepository.findAll();
		return ResponseHandler.generateResponse("Success: List of student", HttpStatus.OK, null, list);
	}

	@Override
	public ResponseEntity<Object> getStudent(Integer id) throws IOException {
		log.info("inside get student by id");
		Optional<StudentEntity> student = studentRepository.findById(id);
		if(!student.isEmpty()) {
			log.info("Success: Get student");
			return ResponseHandler.generateResponse("Success: Get student", HttpStatus.OK, null, student);
		}
		log.error("Invalid given id");
		return ResponseHandler.generateResponse("Not Success", HttpStatus.BAD_REQUEST, "Invalid given id", "");
	}

}
