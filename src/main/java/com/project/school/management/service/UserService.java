package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.UserEntity;
import com.project.school.management.request.AcademicDetailsRequest;
import com.project.school.management.request.HostelDetailsRequest;
import com.project.school.management.request.LoginRequest;
import com.project.school.management.request.OfficeDetailsRequest;
import com.project.school.management.request.PreviousSchoolDetailsRequest;
import com.project.school.management.request.StudentBasicDetailsRequest;
import com.project.school.management.request.TransportDetailsRequest;
import com.project.school.management.request.UserRequest;

public interface UserService {

	UserEntity saveUserDetail(UserRequest userRequest);

	UserEntity login(LoginRequest loginRequest);

	List<UserEntity> getUserList();

	UserEntity getUser(Integer id);

	UserEntity updateUser(UserRequest userRequest);

	UserEntity addStudentBasicDetails(StudentBasicDetailsRequest basicDetailsRequest);

	UserEntity updateAcademicDetails(AcademicDetailsRequest academicDetailsRequest);

	UserEntity updateOfficeDetails(OfficeDetailsRequest officeDetailsRequest);

	UserEntity updateTransportDetails(TransportDetailsRequest transportDetailsRequest);

	UserEntity updatePreSchoolDetails(PreviousSchoolDetailsRequest previousSchoolDetailsRequest);

	UserEntity getStudentDetails(String userId);

	UserEntity updateHostelDetails(HostelDetailsRequest hostelDetailsRequest);

}
