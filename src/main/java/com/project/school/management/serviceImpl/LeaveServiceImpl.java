package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.LeaveEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.LeavesRepository;
import com.project.school.management.request.LeaveRequest;
import com.project.school.management.service.LeavesService;
import com.project.school.management.utility.Utils;
@Service
public class LeaveServiceImpl implements LeavesService{
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private LeavesRepository leavesRepository;

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

}
