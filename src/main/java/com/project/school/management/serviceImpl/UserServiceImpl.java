package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.UserEntity;
import com.project.school.management.exception.AccessDenied;
import com.project.school.management.exception.InvalidArgumentException;
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
		UserEntity user = new UserEntity();
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String str = null;
		str.equals("akash");
		log.info("call function generateUserName");
		String username = generateUserName(userRequest.getEmail(), userRequest.getPhone());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setFatherName(userRequest.getFatherName());
		user.setMotherName(userRequest.getMotherName());
		user.setDateOfBirth(userRequest.getDateOfBirth());
		user.setRole(userRequest.getRole());
		user.setEmail(userRequest.getEmail());
		user.setPhone(userRequest.getPhone());
		user.setGender(userRequest.getGender());
		user.setPassword(bCrypt.encode(userRequest.getPassword()));
		user.setUserName(username);

		log.info("User save");
		userRepository.save(user);
		return user;

	}

	@Override
	public UserEntity login(LoginRequest loginRequest) {
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
		log.info("inside get dtudent method");
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUser(Integer id) {
		log.info("inside get student by id");
		Optional<UserEntity> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}

	// method to generateUserName
	private String generateUserName(String email, Long phone) {
		log.info("inside method generateUserName and call sanitizeString function");

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
		log.info("inside sanitizeString method");
		return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	}

}
