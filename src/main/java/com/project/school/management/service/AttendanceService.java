package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.AttendanceEntity;
import com.project.school.management.entity.StaffAttendanceEntity;
import com.project.school.management.entity.StaffAttendanceStatusEntity;
import com.project.school.management.request.AttendanceRequest;
import com.project.school.management.request.StaffAttendanceRequest;
import com.project.school.management.request.StaffAttendanceStatusRequest;

public interface AttendanceService {

	AttendanceEntity saveAttendance(AttendanceRequest attendanceRequest);

	List<AttendanceEntity> getAttendanceList();

	AttendanceEntity getAttendanceById(Long id);

	Object deleteAttendance(Long id);

	StaffAttendanceStatusEntity saveStaffAttendanceStatus(StaffAttendanceStatusRequest staffAttendanceStatusRequest);

	List<StaffAttendanceStatusEntity> getStaffAttendanceStatus();

	StaffAttendanceEntity saveStaffAttendanceStatus(StaffAttendanceRequest staffAttendanceRequest);

	List<StaffAttendanceEntity> getStaffAttendance();

}
