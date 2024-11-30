package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.LeaveApplicationEntity;
import com.project.school.management.entity.LeaveEntity;
import com.project.school.management.request.LeaveApplicationRequest;
import com.project.school.management.request.LeaveRequest;
import com.project.school.management.request.UpdateLeavesStatusRequest;

public interface LeavesService {

	LeaveEntity saveLeaves(LeaveRequest leaveRequest);

	List<LeaveEntity> getLeavesList();

	LeaveEntity getLeaveById(Long id);

	Object deleteLeaveById(Long id);

	LeaveApplicationEntity applyLeaves(LeaveApplicationRequest leaveApplicationRequest);

	List<LeaveApplicationEntity> getLeavesApplicationList();

	LeaveApplicationEntity getLeavesApplicationById(Long id);

	LeaveApplicationEntity updateLeaves(UpdateLeavesStatusRequest updateLeavesStatusRequest);

}
