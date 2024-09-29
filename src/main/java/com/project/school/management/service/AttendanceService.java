package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.AttendanceEntity;
import com.project.school.management.request.AttendanceRequest;

public interface AttendanceService {

	AttendanceEntity saveAttendance(AttendanceRequest attendanceRequest);

	List<AttendanceEntity> getAttendanceList();

	AttendanceEntity getAttendanceById(Long id);

	Object deleteAttendance(Long id);

}
