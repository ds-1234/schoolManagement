package com.project.school.management.serviceImpl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.entity.AttendanceEntity;
import com.project.school.management.entity.EventEntity;
import com.project.school.management.entity.StaffAttendanceEntity;
import com.project.school.management.entity.StaffAttendanceStatusEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.AttendanceRepository;
import com.project.school.management.repository.StaffAttendanceRepository;
import com.project.school.management.repository.StaffAttendanceStatusRepository;
import com.project.school.management.request.AttendanceRequest;
import com.project.school.management.request.StaffAttendanceRequest;
import com.project.school.management.request.StaffAttendanceStatusRequest;
import com.project.school.management.service.AttendanceService;
import com.project.school.management.utility.Utils;
@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private StaffAttendanceStatusRepository staffAttendanceStatusRepo;
	
	@Autowired
	private StaffAttendanceRepository staffAttendanceRepo;
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public AttendanceServiceImpl(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public AttendanceEntity saveAttendance(AttendanceRequest attendanceRequest) {
		AttendanceEntity entity = new AttendanceEntity();
		if(Objects.isNull(attendanceRequest.getId())) {
			entity.setTeacher(attendanceRequest.getTeacher());
			entity.setAttendanceDate(attendanceRequest.getAttendanceDate());
			String attendanceId = utils.generateRandomId();
			entity.setAttendanceId("AD"+attendanceId);
			entity.setClassName(attendanceRequest.getClassName());
			entity.setAttendanceStatusList(attendanceRequest.getAttendanceStatusList());
			return attendanceRepository.save(entity);
		}else {
			AttendanceEntity dbAttendanceEntity = attendanceRepository.findById(attendanceRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given id is invalid"));
			dbAttendanceEntity.setAttendanceStatusList(attendanceRequest.getAttendanceStatusList());
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


	@Override
	public StaffAttendanceStatusEntity saveStaffAttendanceStatus(
			StaffAttendanceStatusRequest staffAttendanceStatusRequest) {
		if(Objects.isNull(staffAttendanceStatusRequest.getStartTime()) || Objects.isNull(staffAttendanceStatusRequest.getEndTime())
				|| Objects.isNull(staffAttendanceStatusRequest.getAttendanceStatus())) {
			throw new InvalidArgumentException("Invalid data or data missing");
		}
		StaffAttendanceStatusEntity entity = objectMapper.convertValue(staffAttendanceStatusRequest, StaffAttendanceStatusEntity.class);
		if(Objects.isNull(staffAttendanceStatusRequest.getId())) {
			Long lastId = staffAttendanceStatusRepo.findMaxId();
			long newId = (lastId == null || lastId == 0) ? 1 : lastId + 1;
			entity.setId(newId);
		}
		return staffAttendanceStatusRepo.save(entity);
	}

	@Override
	public List<StaffAttendanceStatusEntity> getStaffAttendanceStatus() {
		return staffAttendanceStatusRepo.findAll();
	}

	@Override
	public StaffAttendanceEntity saveStaffAttendanceStatus(StaffAttendanceRequest staffAttendanceRequest) {
		if(Objects.isNull(staffAttendanceRequest.getLogindateTime()) || Objects.isNull(staffAttendanceRequest.getLongitude())
				|| Objects.isNull(staffAttendanceRequest.getLatitude())) {
			throw new InvalidArgumentException("Given data is invalid or missing");
		}
		StaffAttendanceEntity entity = objectMapper.convertValue(staffAttendanceRequest, StaffAttendanceEntity.class);
		Long lastId = staffAttendanceRepo.findMaxId();
		long newId = (lastId == null || lastId == 0) ? 1 : lastId + 1;
		entity.setId(newId);
		List<StaffAttendanceStatusEntity> timeList = staffAttendanceStatusRepo.findAll(); 

        // Extract the time part from the LocalDateTime
        LocalTime requestTime = staffAttendanceRequest.getLogindateTime().toLocalTime();
        String attStatus = getStatusForTime(requestTime, timeList);
        entity.setAttendanceStatus(attStatus);
        entity.setAttendanceDate(staffAttendanceRequest.getLogindateTime().toLocalDate());
		return staffAttendanceRepo.save(entity);
	}
	
	public String getStatusForTime(LocalTime requestTime, List<StaffAttendanceStatusEntity> timeRanges) {
        for (StaffAttendanceStatusEntity timeRange : timeRanges) {
        	if((requestTime.equals(timeRange.getStartTime()) || requestTime.isAfter(timeRange.getStartTime()))
        			&& (requestTime.equals(timeRange.getEndTime()) || requestTime.isBefore(timeRange.getEndTime())))
                return timeRange.getAttendanceStatus();
        }
        return "Out of Range";  // If no match is found
    }

	@Override
	public List<StaffAttendanceEntity> getStaffAttendance() {
		return staffAttendanceRepo.findAll();
	}
}
