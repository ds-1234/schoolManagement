package com.project.school.management.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.school.management.constant.Message;
import com.project.school.management.entity.LeaveApplicationEntity;
import com.project.school.management.entity.LeaveEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.LeaveApplicationRepository;
import com.project.school.management.repository.LeavesRepository;
import com.project.school.management.request.LeaveApplicationRequest;
import com.project.school.management.request.LeaveRequest;
import com.project.school.management.service.LeavesService;
import com.project.school.management.utility.Utils;
@Service
public class LeaveServiceImpl implements LeavesService{
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private LeavesRepository leavesRepository;
	
	@Autowired
	private LeaveApplicationRepository leaveApplicationRepository;

	@Override
	public LeaveEntity saveLeaves(LeaveRequest leaveRequest) {
		LeaveEntity entity = new LeaveEntity();
		if(Objects.isNull(leaveRequest.getId())) {
			String leaveId = utils.generateRandomId();
			entity.setLeaveId("LT"+leaveId);
			
			String leaveTypeName = utils.capitalizeFirstCharacter(leaveRequest.getLeaveType());
			entity.setLeaveType(leaveTypeName);
			
			entity.setLeaveDescription(leaveRequest.getLeaveDescription());
			entity.setIsActive(leaveRequest.getIsActive());
			return leavesRepository.save(entity);
		}else {
			LeaveEntity dbData = leavesRepository.findById(leaveRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid"));
			dbData.setLeaveType(leaveRequest.getLeaveType());
			dbData.setLeaveDescription(leaveRequest.getLeaveDescription());
			dbData.setIsActive(leaveRequest.getIsActive());
			return leavesRepository.save(dbData);
		}
	}

	@Override
	public List<LeaveEntity> getLeavesList() {
		return this.leavesRepository.findAll();
	}

	@Override
	public LeaveEntity getLeaveById(Long id) {
		LeaveEntity dbData = leavesRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid"));
		return dbData;
	}

	@Override
	public Object deleteLeaveById(Long id) {
		LeaveEntity dbData = leavesRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid"));
		leavesRepository.delete(dbData);
		return dbData.getLeaveType()+" is deleted successfully";
	}

	@Override
	public LeaveApplicationEntity applyLeaves(LeaveApplicationRequest leaveApplicationRequest) {
		LeaveApplicationEntity entity = new LeaveApplicationEntity();
		String randomId = utils.generateRandomId();
		entity.setLeaveApplicationId("LA"+randomId);
		entity.setSenderId(leaveApplicationRequest.getSenderId());
		entity.setLeaveAuthoriserId(leaveApplicationRequest.getLeaveAuthoriserId());
		
		LocalDate currentDate = LocalDate.now();
		entity.setAppliedOn(currentDate);
		
		entity.setLeaveStartDate(leaveApplicationRequest.getLeaveStartDate());
		entity.setLeaveEndDate(leaveApplicationRequest.getLeaveEndDate());
		Period period = utils.dateDuration(leaveApplicationRequest.getLeaveStartDate(), leaveApplicationRequest.getLeaveEndDate());
		if(period.getDays()==0) {
			entity.setLeaveDayDuration(Message.SAME_DAY);
		}else {
			entity.setLeaveDayDuration(period.getDays());
		}
		entity.setLeaveReason(leaveApplicationRequest.getLeaveReason());
		entity.setLeaveStatus(Message.LEAVE_PENDING);
		entity.setRollOrEmployeeId(leaveApplicationRequest.getRollOrEmployeeId());
		entity.setLeaveType(leaveApplicationRequest.getLeaveType());
		return leaveApplicationRepository.save(entity);
	}

	@Override
	public List<LeaveApplicationEntity> getLeavesApplicationList() {
		return leaveApplicationRepository.findAll(Sort.by(Sort.Order.asc("appliedOn")));
	}

	@Override
	public LeaveApplicationEntity getLeavesApplicationById(Long id) {
		return leaveApplicationRepository.findById(id).orElseThrow(()-> new InvalidArgumentException("Data is not present by given id"));
	}

	@Override
	public String updateLeaves(Long id, String leaveStatus) {
		LeaveApplicationEntity dbData = leaveApplicationRepository.findById(id).orElseThrow(()-> new InvalidArgumentException("Data is not present by given id"));
		if(leaveStatus.equalsIgnoreCase("Approved")) {
			dbData.setLeaveStatus(Message.LEAVE_APPROVED);
		}else if(leaveStatus.equalsIgnoreCase("Rejected")) {
			dbData.setLeaveStatus(Message.LEAVE_REJECTED);
		}else {
			dbData.setLeaveStatus(leaveStatus);
		}
		
		leaveApplicationRepository.save(dbData);
		return "Data updated successfully";
	}

}
