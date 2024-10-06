package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.AttendanceEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.AttendanceRepository;
import com.project.school.management.request.AttendanceRequest;
import com.project.school.management.service.AttendanceService;
import com.project.school.management.utility.Utils;
@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private Utils utils;

	@Override
	public AttendanceEntity saveAttendance(AttendanceRequest attendanceRequest) {
		AttendanceEntity entity = new AttendanceEntity();
		if(Objects.isNull(attendanceRequest.getId())) {
			entity.setUserStudentId(attendanceRequest.getStudentId());
			entity.setUserTeacherId(attendanceRequest.getTeacherId());
			entity.setAttendanceDate(attendanceRequest.getAttendanceDate());
			String attendanceId = utils.generateRandomId();
			entity.setAttendanceId("AD"+attendanceId);
			entity.setAttendanceStatus(attendanceRequest.getAttendanceStatus());
			entity.setClassId(attendanceRequest.getClassId());
			return attendanceRepository.save(entity);
		}else {
			AttendanceEntity dbAttendanceEntity = attendanceRepository.findById(attendanceRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given id is invalid"));
			dbAttendanceEntity.setAttendanceStatus(attendanceRequest.getAttendanceStatus());
			return attendanceRepository.save(dbAttendanceEntity);
		}
		
	}

	@Override
	public List<AttendanceEntity> getAttendanceList() {
		return attendanceRepository.findAll();
	}

	@Override
	public AttendanceEntity getAttendanceById(Long id) {
		AttendanceEntity dbAttendanceEntity = attendanceRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or empty"));
		return dbAttendanceEntity;
	}

	@Override
	public Object deleteAttendance(Long id) {
		AttendanceEntity dbAttendanceEntity = attendanceRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or empty"));
		attendanceRepository.delete(dbAttendanceEntity);
		return "deleted successfully";
	}

}
