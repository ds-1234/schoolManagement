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
import com.project.school.management.entity.Role;
import com.project.school.management.entity.UserEntity;
import com.project.school.management.entity.UserLeaveCounterEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.LeaveApplicationRepository;
import com.project.school.management.repository.LeaveCounterRepository;
import com.project.school.management.repository.LeavesRepository;
import com.project.school.management.repository.RoleRepository;
import com.project.school.management.repository.UserRepository;
import com.project.school.management.request.LeaveApplicationRequest;
import com.project.school.management.request.LeaveRequest;
import com.project.school.management.request.UpdateLeavesStatusRequest;
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
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private LeaveCounterRepository leaveCounterRepository;

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
		entity.setLeaveDayDuration(period.getDays()+1);
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
	public LeaveApplicationEntity updateLeaves(UpdateLeavesStatusRequest updateLeavesStatusRequest) {
		LeaveApplicationEntity dbData = leaveApplicationRepository.findById(updateLeavesStatusRequest.getId()).orElseThrow(()-> new InvalidArgumentException("Data is not present by given id"));
		if(updateLeavesStatusRequest.getLeaveStatus().equalsIgnoreCase("Approved")) {
			dbData.setLeaveStatus(Message.LEAVE_APPROVED);
			UserEntity entity = userRepository.findById(dbData.getSenderId())
					.orElseThrow(()-> new InvalidArgumentException("Data is not available by senderId"));
			Role role = roleRepository.findById(entity.getRole())
					.orElseThrow(()-> new InvalidArgumentException("Data not present by given role id"));
			if((!role.getName().equalsIgnoreCase("student")) || (!role.getName().equalsIgnoreCase("students"))) {
				UserLeaveCounterEntity assignedLeaves = leaveCounterRepository.findByStaffIdAndLeaveTypes(dbData.getSenderId(), dbData.getLeaveType());
				Long finalCount = assignedLeaves.getLeaveCount()-dbData.getLeaveDayDuration();
				assignedLeaves.setLeaveCount(finalCount);
				leaveCounterRepository.save(assignedLeaves);
			}
			
		}else if(updateLeavesStatusRequest.getLeaveStatus().equalsIgnoreCase("Rejected")) {
			dbData.setLeaveStatus(Message.LEAVE_REJECTED);
			dbData.setLeaveRejectionReason(updateLeavesStatusRequest.getLeaveRejectionReason());
		}else {
			dbData.setLeaveStatus(updateLeavesStatusRequest.getLeaveStatus());
		}
		leaveApplicationRepository.save(dbData);
		return dbData;
	}

}
