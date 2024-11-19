package com.project.school.management.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.school.management.constant.Message;
import com.project.school.management.entity.UserEntity;
import com.project.school.management.enums.ErrorCode;
import com.project.school.management.exception.AccessDenied;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.exception.InvalidPhoneException;
import com.project.school.management.exception.UserNotFoundException;
import com.project.school.management.repository.UserRepository;
import com.project.school.management.request.AcademicDetailsRequest;
import com.project.school.management.request.HostelDetailsRequest;
import com.project.school.management.request.LoginRequest;
import com.project.school.management.request.OfficeDetailsRequest;
import com.project.school.management.request.PreviousSchoolDetailsRequest;
import com.project.school.management.request.StudentBasicDetailsRequest;
import com.project.school.management.request.StudentPromotionRequest;
import com.project.school.management.request.TransportDetailsRequest;
import com.project.school.management.request.UserRequest;
import com.project.school.management.service.UserService;
import com.project.school.management.utility.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Utils utils;

	@Override
	public UserEntity saveUserDetail(UserRequest userRequest) {
		if (userRequest.getPhone().length() < 10) {
			throw new InvalidArgumentException(Message.INVALID_MOBILE_NUMBER);
		}

		UserEntity user = new UserEntity();
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String username = null;
		if(Objects.isNull(userRequest.getUserName())) {
			username = generateUserName(userRequest.getEmail(), userRequest.getPhone());
			user.setUserName(username);
		}else {
			user.setUserName(userRequest.getUserName());
		}
		
		user.setId(userRequest.getId());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setFatherName(userRequest.getFatherName());
		user.setMotherName(userRequest.getMotherName());
		user.setDateOfBirth(userRequest.getDateOfBirth());
		user.setEmail(userRequest.getEmail());
		user.setPhone(userRequest.getPhone());
		user.setGender(userRequest.getGender());
		user.setPassword(bCrypt.encode(userRequest.getPassword()));
		if(Objects.isNull(userRequest.getUserId())) {
			user.setUserId(this.generateUserId());
		}else {
			user.setUserId(userRequest.getUserId());
		}
		user.setHouseNumber(userRequest.getHouseNumber());
		user.setStreet(userRequest.getStreet());
		user.setCity(userRequest.getCity());
		user.setState(userRequest.getState());
		user.setPinCode(userRequest.getPinCode());
		user.setCountry(userRequest.getCountry());
		user.setIsParent(userRequest.getIsParent());

		user.setClassName(userRequest.getClassName());
		user.setBook(userRequest.getBook());
		user.setIsActive(userRequest.getIsActive());

		user.setRole(userRequest.getRole());
		user.setSchool(userRequest.getSchool());
		userRepository.save(user);
		return user;

	}

	@Override
	public UserEntity login(LoginRequest loginRequest) {
		if (StringUtils.isEmpty(loginRequest.getUserName()) || StringUtils.isEmpty(loginRequest.getPassword())) {
			throw new InvalidArgumentException();
		}
		UserEntity opUser = userRepository.findByUserId(loginRequest.getUserName());
		if (ObjectUtils.isEmpty(opUser) ) {
			throw new UserNotFoundException();
		}
//		UserEntity dbUser = opUser.get();
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		if (bCrypt.matches(loginRequest.getPassword(), opUser.getPassword())) {
			opUser.setPassword(null);
			return opUser;
		} else {
			throw new AccessDenied();
		}
	}

	@Override
	public List<UserEntity> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUser(Integer id) {
		Optional<UserEntity> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}

	// method to generateUserName
	private String generateUserName(String email, String phone) {

		String[] parts = email.split("@");

		String sanitizedPhoneNumber = sanitizeString(String.valueOf(phone));
		String contact = sanitizedPhoneNumber.substring(sanitizedPhoneNumber.length() - 4);

		// Concatenate the sanitized email and phone number
		String concatenatedString = parts[0] + contact;

		Optional<UserEntity> userEntityContainer = this.userRepository.findByUserName(concatenatedString);
		
		if (userEntityContainer.isPresent()) {
			String mobile = userEntityContainer.get().getPhone() + this.generateRandomAlphanumeric(2);
			concatenatedString = this.generateUserName(email, mobile);
		}

		return concatenatedString;
	}

	private String sanitizeString(String input) {
		return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	}

	private String generateUserId() {
		String userId = this.generateRandomAlphanumeric(5);
		UserEntity user = userRepository.findByUserId(userId);
		if(ObjectUtils.isNotEmpty(user)){
			this.generateUserId();
		}
		return userId;

	}
	
	private String generateRandomAlphanumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	@Override
	public UserEntity updateUser(UserRequest userRequest) {

		if (userRequest.getPhone().length() < 10) {
			throw new InvalidArgumentException(Message.INVALID_MOBILE_NUMBER);
		}

		Optional<UserEntity> userContainer = this.userRepository.findById(userRequest.getId());
		if(userContainer.isEmpty()) {
			throw new UserNotFoundException();
		}
		UserEntity user = userContainer.get();
		
		//BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setFatherName(userRequest.getFatherName());
		user.setMotherName(userRequest.getMotherName());
		user.setDateOfBirth(userRequest.getDateOfBirth());
		user.setEmail(userRequest.getEmail());
		user.setPhone(userRequest.getPhone());
		user.setGender(userRequest.getGender());
		//user.setPassword(bCrypt.encode(userRequest.getPassword()));
		//user.setUserId(this.generateUserId());
		user.setHouseNumber(userRequest.getHouseNumber());
		user.setStreet(userRequest.getStreet());
		user.setCity(userRequest.getCity());
		user.setState(userRequest.getState());
		user.setPinCode(userRequest.getPinCode());
		user.setCountry(userRequest.getCountry());

		user.setClassName(userRequest.getClassName());
		user.setBook(userRequest.getBook());
		user.setIsActive(userRequest.getIsActive());

		user.setRole(userRequest.getRole());
		user.setSchool(userRequest.getSchool());
		userRepository.save(user);
		return user;

	
	}

	@Override
	public UserEntity addStudentBasicDetails(StudentBasicDetailsRequest basicDetailsRequest) {
		if(Objects.isNull(basicDetailsRequest.getUserId()) ) {
		UserEntity entity = new UserEntity();
		//BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		if(Objects.isNull(basicDetailsRequest.getFirstName())) {
			throw new InvalidArgumentException("Student First Name is empty");
		}
		entity.setFirstName(basicDetailsRequest.getFirstName());
		
		if(Objects.isNull(basicDetailsRequest.getLastName())) {
			throw new InvalidArgumentException("Student Last Name is empty");
		}
		entity.setLastName(basicDetailsRequest.getLastName());
		
		if(Objects.isNull(basicDetailsRequest.getEmail())) {
			throw new InvalidArgumentException("Email is empty");
		}
		entity.setEmail(basicDetailsRequest.getEmail());
		
		if(Objects.isNull(basicDetailsRequest.getPhone())) {
			throw new InvalidArgumentException("Phone Number is empty");
		}
		if (basicDetailsRequest.getPhone().length() < 10) {
			throw new InvalidPhoneException(ErrorCode.INVALID_PHONE_NUMBER, HttpStatus.BAD_REQUEST);
		}
		entity.setPhone(basicDetailsRequest.getPhone());
		
		if(Objects.isNull(basicDetailsRequest.getFatherName())) {
			throw new InvalidArgumentException("Student's Father Name is empty");
		}
		entity.setFatherName(basicDetailsRequest.getFatherName());
		
		if(Objects.isNull(basicDetailsRequest.getMotherName())) {
			throw new InvalidArgumentException("Student's Mother Name is empty");
		}
		entity.setMotherName(basicDetailsRequest.getMotherName());
		
		if(Objects.isNull(basicDetailsRequest.getGender())) {
			throw new InvalidArgumentException("Gender is empty");
		}
		entity.setGender(basicDetailsRequest.getGender());
		
		if(Objects.isNull(basicDetailsRequest.getDateOfBirth())) {
			throw new InvalidArgumentException("Student's Date of Birth is empty");
		}
		entity.setDateOfBirth(basicDetailsRequest.getDateOfBirth());
		
		if(Objects.isNull(basicDetailsRequest.getHouseNumber())) {
			throw new InvalidArgumentException("Student's House number is empty");
		}
		entity.setHouseNumber(basicDetailsRequest.getHouseNumber());
		
		if(Objects.isNull(basicDetailsRequest.getCity())) {
			throw new InvalidArgumentException("City/village is empty");
		}
		entity.setCity(basicDetailsRequest.getCity());
		entity.setStreet(basicDetailsRequest.getStreet());
		
		if(Objects.isNull(basicDetailsRequest.getState())) {
			throw new InvalidArgumentException("State is empty");
		}
		entity.setState(basicDetailsRequest.getState());
		
		if(Objects.isNull(basicDetailsRequest.getPinCode())) {
			throw new InvalidArgumentException("Pincode is empty");
		}
		entity.setPinCode(basicDetailsRequest.getPinCode());
		
		if(Objects.isNull(basicDetailsRequest.getCountry())) {
			throw new InvalidArgumentException("Country is empty");
		}
		entity.setCountry(basicDetailsRequest.getCountry());
		entity.setBloodGroup(basicDetailsRequest.getBloodGroup());
		
		if(Objects.isNull(basicDetailsRequest.getReligion())) {
			throw new InvalidArgumentException("Religion is empty");
		}
		entity.setReligion(basicDetailsRequest.getReligion());
		
		if(Objects.isNull(basicDetailsRequest.getCasteCategory())) {
			throw new InvalidArgumentException("Caste Category is empty");
		}
		entity.setCasteCategory(basicDetailsRequest.getCasteCategory());
		
		if(Objects.isNull(basicDetailsRequest.getRole())) {
			throw new InvalidArgumentException("Role is empty");
		}
		entity.setRole(basicDetailsRequest.getRole());
		
			BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
			String randomPassword = utils.generateRandomPassword();
			entity.setPassword(bCrypt.encode(randomPassword));
			entity.setUserName(generateUserName(basicDetailsRequest.getEmail(), basicDetailsRequest.getPhone()));
			entity.setUserId(this.generateUserId());
			return userRepository.save(entity);
		}else {
			UserEntity dbData = userRepository.findByUserId(basicDetailsRequest.getUserId());
			if(!Objects.isNull(dbData)) {
				dbData.setFirstName(basicDetailsRequest.getFirstName());
				dbData.setLastName(basicDetailsRequest.getLastName());
				dbData.setEmail(basicDetailsRequest.getEmail());
				dbData.setPhone(basicDetailsRequest.getPhone());
				dbData.setFatherName(basicDetailsRequest.getFatherName());
				dbData.setMotherName(basicDetailsRequest.getMotherName());
				dbData.setGender(basicDetailsRequest.getGender());
				dbData.setDateOfBirth(basicDetailsRequest.getDateOfBirth());
				dbData.setHouseNumber(basicDetailsRequest.getHouseNumber());
				dbData.setCity(basicDetailsRequest.getCity());
				dbData.setStreet(basicDetailsRequest.getStreet());
				dbData.setState(basicDetailsRequest.getState());
				dbData.setPinCode(basicDetailsRequest.getPinCode());
				dbData.setCountry(basicDetailsRequest.getCountry());
				dbData.setBloodGroup(basicDetailsRequest.getBloodGroup());
				dbData.setReligion(basicDetailsRequest.getReligion());
				dbData.setCasteCategory(basicDetailsRequest.getCasteCategory());
				dbData.setRole(basicDetailsRequest.getRole());
				
			}
			return userRepository.save(dbData);
		}
		
	}

	@Override
	public UserEntity updateAcademicDetails(AcademicDetailsRequest academicDetailsRequest) {
		UserEntity dbdata = userRepository.findByUserId(academicDetailsRequest.getUserId());
		if(Objects.isNull(dbdata)) {
			throw new InvalidArgumentException(ErrorCode.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
		}
		if(Objects.isNull(academicDetailsRequest.getSchool())) {
			throw new InvalidArgumentException("School Branch is empty");
		}
		dbdata.setSchool(academicDetailsRequest.getSchool());
		
		if(Objects.isNull(academicDetailsRequest.getClassName())) {
			throw new InvalidArgumentException("Class is empty");
		}
		dbdata.setClassName(academicDetailsRequest.getClassName());
		
		if(Objects.isNull(academicDetailsRequest.getAcademicYear())) {
			throw new InvalidArgumentException("Academic year is empty");
		}
		dbdata.setAcademicYear(academicDetailsRequest.getAcademicYear());
		
		if(Objects.isNull(academicDetailsRequest.getRollNumber())) {
			throw new InvalidArgumentException("Roll Number is empty");
		}
		dbdata.setRollNumber(academicDetailsRequest.getRollNumber());
		return userRepository.save(dbdata);
	}

	@Override
	public UserEntity updateOfficeDetails(OfficeDetailsRequest officeDetailsRequest) {
		UserEntity dbdata = userRepository.findByUserId(officeDetailsRequest.getUserId());
		if(Objects.isNull(dbdata)) {
			throw new InvalidArgumentException(ErrorCode.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
		}
		if(Objects.isNull(officeDetailsRequest.getAdmissionNumber())) {
			throw new InvalidArgumentException("Admission number is empty");
		}
		dbdata.setAdmissionNumber(officeDetailsRequest.getAdmissionNumber());
		
		if(Objects.isNull(officeDetailsRequest.getAdmissionDate())) {
			throw new InvalidArgumentException("Admission date is empty");
		}
		dbdata.setAdmissionDate(officeDetailsRequest.getAdmissionDate());
		dbdata.setSiblings(officeDetailsRequest.getSiblings());
		dbdata.setKnownAllergies(officeDetailsRequest.getKnownAllergies());
		dbdata.setMedications(officeDetailsRequest.getMedications());
		return userRepository.save(dbdata);
	}

	@Override
	public UserEntity updateTransportDetails(TransportDetailsRequest transportDetailsRequest) {
		UserEntity dbdata = userRepository.findByUserId(transportDetailsRequest.getUserId());
		if(Objects.isNull(dbdata)) {
			throw new InvalidArgumentException(ErrorCode.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
		}
		if(Objects.isNull(transportDetailsRequest.getRouteName())) {
			throw new InvalidArgumentException("Route Name is empty");
		}
		dbdata.setRouteName(transportDetailsRequest.getRouteName());
		
		if(Objects.isNull(transportDetailsRequest.getPickupPoint())) {
			throw new InvalidArgumentException("Pickup point is empty");
		}
		
		dbdata.setPickupPoint(transportDetailsRequest.getPickupPoint());
		return userRepository.save(dbdata);
	}

	@Override
	public UserEntity updatePreSchoolDetails(PreviousSchoolDetailsRequest previousSchoolDetailsRequest) {
		UserEntity dbdata = userRepository.findByUserId(previousSchoolDetailsRequest.getUserId());
		if(Objects.isNull(dbdata)) {
			throw new InvalidArgumentException(ErrorCode.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
		}
		if(Objects.isNull(previousSchoolDetailsRequest.getPreviousSchoolName())) {
			throw new InvalidArgumentException("Previous School Name is empty");
		}
		dbdata.setPreviousSchoolName(previousSchoolDetailsRequest.getPreviousSchoolName());
		
		if(Objects.isNull(previousSchoolDetailsRequest.getPreSchoolAddress())) {
			throw new InvalidArgumentException("Previous School Address is empty");
		}
		dbdata.setPreSchoolAddress(previousSchoolDetailsRequest.getPreSchoolAddress());
		
		if(Objects.isNull(previousSchoolDetailsRequest.getPreSchoolLeavingSession())) {
			throw new InvalidArgumentException("Previous School Leaving Session is empty");
		}
		dbdata.setPreSchoolLeavingSession(previousSchoolDetailsRequest.getPreSchoolLeavingSession());
//		dbdata.setIsActive(previousSchoolDetailsRequest.getStatus());
		return userRepository.save(dbdata);
		
	}

	@Override
	public UserEntity getStudentDetails(String userId) {
		UserEntity dbdata = userRepository.findByUserId(userId);
		if(Objects.isNull(dbdata)) {
			throw new InvalidArgumentException(ErrorCode.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
		}
		return dbdata;
	}

	@Override
	public UserEntity updateHostelDetails(HostelDetailsRequest hostelDetailsRequest) {
		UserEntity dbdata = userRepository.findByUserId(hostelDetailsRequest.getUserId());
		if(Objects.isNull(dbdata)) {
			throw new InvalidArgumentException(ErrorCode.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
		}
		if(Objects.isNull(hostelDetailsRequest.getBuildingName())) {
			throw new InvalidArgumentException("Building Name is empty");
		}
		dbdata.setBuildingName(hostelDetailsRequest.getBuildingName());
		
		if(Objects.isNull(hostelDetailsRequest.getRoomNumber())) {
			throw new InvalidArgumentException("Room number is empty");
		}
		dbdata.setRoomNumber(hostelDetailsRequest.getRoomNumber());
		return userRepository.save(dbdata);
	}

	@Override
	public Object updateStudentPromotion(StudentPromotionRequest studentPromotionRequest) {
		Map<Long, String> map = new HashMap<>();
		if(ObjectUtils.isNotEmpty(studentPromotionRequest) && ObjectUtils.isNotEmpty(studentPromotionRequest.getUsers())) {
			studentPromotionRequest.getUsers().stream().forEach(x->{
				Optional<UserEntity> userContainer = userRepository.findById(x.getId());
				if(userContainer.isPresent()) {
					userContainer.get().setClassName(studentPromotionRequest.getClassName());
					userContainer.get().setAcademicYear(studentPromotionRequest.getPromotedSession());
					userRepository.save(userContainer.get());
					map.put(x.getId(), "Success");
				}else {
					map.put(x.getId(), "Failed");
				}
			 });
		}
		 
		 
		return map;
	}
	

}
