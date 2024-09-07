package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.UserEntity;
import com.project.school.management.request.LoginRequest;
import com.project.school.management.request.UserRequest;

public interface UserService {

	UserEntity saveUserDetail(UserRequest userRequest);

	UserEntity login(LoginRequest loginRequest);

	List<UserEntity> getUserList();

	UserEntity getUser(Integer id);

}
