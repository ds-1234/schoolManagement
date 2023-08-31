package com.project.school.management.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.Role;
import com.project.school.management.entity.UserEntity;
import com.project.school.management.exception.AccessDenied;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.exception.InvalidPhoneNumberException;
import com.project.school.management.exception.UserNotFoundException;
import com.project.school.management.repository.UserRepository;
import com.project.school.management.request.LoginRequest;
import com.project.school.management.request.UserRequest;
import com.project.school.management.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity saveUserDetail(UserRequest userRequest) {
		log.info("Inside " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (userRequest.getPhone().length() < 10) {
			throw new InvalidPhoneNumberException();
		}

		UserEntity user = new UserEntity();
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		log.info("call function generateUserName");
		String username = generateUserName(userRequest.getEmail(), userRequest.getPhone());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setFatherName(userRequest.getFatherName());
		user.setMotherName(userRequest.getMotherName());
		user.setDateOfBirth(userRequest.getDateOfBirth());
		user.setEmail(userRequest.getEmail());
		user.setPhone(userRequest.getPhone());
		user.setGender(userRequest.getGender());
		user.setPassword(bCrypt.encode(userRequest.getPassword()));
		user.setUserName(username);
		user.setUserId(generateUserId(userRequest.getRole()));
		user.setAddress(userRequest.getAddress());
		user.setClassName(userRequest.getClassName());
		user.setBook(userRequest.getBook());
		user.setIsActive(userRequest.getIsActive());

		user.setRole(userRequest.getRole());
		user.setSchool(userRequest.getSchool());
		log.info("User save");
		userRepository.save(user);
		return user;

	}

	@Override
	public UserEntity login(LoginRequest loginRequest) {
		log.info("Inside " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (StringUtils.isEmpty(loginRequest.getUserName()) || StringUtils.isEmpty(loginRequest.getPassword())) {
			throw new InvalidArgumentException();
		}
		log.info("login by username");
		Optional<UserEntity> opUser = userRepository.findByUserName(loginRequest.getUserName());
		if (opUser.isEmpty()) {
			throw new UserNotFoundException();
		}
		UserEntity dbUser = opUser.get();
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		if (bCrypt.matches(loginRequest.getPassword(), dbUser.getPassword())) {
			log.info("login successfully by username");
			dbUser.setPassword(null);
			return dbUser;
		} else {
			throw new AccessDenied();
		}
	}

	@Override
	public List<UserEntity> getUserList() {
		log.info("Inside " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUser(Integer id) {
		log.info("Inside " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Optional<UserEntity> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}

	// method to generateUserName
	private String generateUserName(String email, String phone) {
		log.info("Inside " + Thread.currentThread().getStackTrace()[1].getMethodName());

		String[] parts = email.split("@");

		String sanitizedPhoneNumber = sanitizeString(String.valueOf(phone));
		String contact = sanitizedPhoneNumber.substring(sanitizedPhoneNumber.length() - 4);

		// Concatenate the sanitized email and phone number
		log.info("concatenate email and phone");
		String concatenatedString = parts[0] + contact;

		if (this.userRepository.findByUserName(concatenatedString).isPresent()) {
			this.generateUserName(email, phone + 1);
		}

		return concatenatedString;
	}

	private String sanitizeString(String input) {
		log.info("Inside " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	}

	private String generateUserId(Role role) {
		log.info("Inside " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String userId = role.getName().substring(0, 1);
		LocalDateTime localDate = LocalDateTime.now();
		Long count = this.userRepository.countByRole(role);
		count++;
		userId = userId.concat(String.valueOf(localDate.getYear())).concat(count.toString());
		return userId;

	}

}
