package com.project.school.management.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.dto.LeaveCounterDto;
import com.project.school.management.entity.TeacherInfoEntity;
import com.project.school.management.entity.UserLeaveCounterEntity;
import com.project.school.management.repository.LeaveCounterRepository;
import com.project.school.management.repository.TeacherInfoRepository;
import com.project.school.management.request.HrmDetailsDto;
import com.project.school.management.service.HrmService;
@Service
public class HrmServiceImpl implements HrmService{
	
	@Autowired
	private TeacherInfoRepository teacherInfoRepository;
	
	@Autowired
	private LeaveCounterRepository leaveCounterRepository;

	@Override
	public HrmDetailsDto saveHrmDetails(HrmDetailsDto hrmDetailsDto) {
		TeacherInfoEntity entity = teacherInfoRepository.findByTeacherId(hrmDetailsDto.getTeacherId().toString());
		entity.setBasicSalary(hrmDetailsDto.getBasicSalary());
		entity.setContractType(hrmDetailsDto.getContractType());
		entity.setEmployeeNumber(hrmDetailsDto.getEmployeeNumber());
		entity.setEpfNumber(hrmDetailsDto.getEpfNumber());
		entity.setWorkLocation(hrmDetailsDto.getWorkLocation());
		entity.setWorkShift(hrmDetailsDto.getWorkShift());
		teacherInfoRepository.save(entity);
		if(!entity.getEmployeeNumber().isBlank()) {
			
			for(LeaveCounterDto leaveCount : hrmDetailsDto.getLeaveCounterDto()) {
				UserLeaveCounterEntity leaveCounterEntity = new UserLeaveCounterEntity();
				leaveCounterEntity.setLeaveTypes(leaveCount.getLeaveTypes());
				leaveCounterEntity.setLeaveCount(leaveCount.getLeaveCount());
				leaveCounterEntity.setStaffId(hrmDetailsDto.getTeacherId());
				leaveCounterRepository.save(leaveCounterEntity);
			}		
			
		}
		return hrmDetailsDto;
	}

	@Override
	public List<UserLeaveCounterEntity> getLeaveCounterDetailsById(Long staffId) {
		return leaveCounterRepository.findAllByStaffId(staffId);
	}

}
