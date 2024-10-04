package com.project.school.management;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.school.management.entity.Role;
import com.project.school.management.entity.UserEntity;
import com.project.school.management.enums.Gender;
import com.project.school.management.repository.RoleRepository;
import com.project.school.management.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		this.roleRepository.save(new Role(Long.valueOf(1), "Guest", true));
		Role role = this.roleRepository.save(new Role(Long.valueOf(2), "Admin", true));
		this.userRepository.save(saveData(role));
	}

	private UserEntity saveData(Role role) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		UserEntity userEntity = UserEntity.builder().id(Long.valueOf(1)).firstName("Admin").lastName("").fatherName("").motherName("").userId("admin")
				.dateOfBirth(new Date()).houseNumber("").street("").city("").state("").pinCode("").country("").userName("admin")
				.gender(Gender.Male).role(Long.valueOf(1)).email("admin@gmail.com").phone("1234567890").password(bCrypt.encode("Admin@123")).isActive(true).build();
		return userEntity;
	}

}
