package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.LeaveEntity;
import com.project.school.management.request.LeaveRequest;

public interface LeavesService {

	LeaveEntity saveLeaves(LeaveRequest leaveRequest);

	List<LeaveEntity> getLeavesList();

	LeaveEntity getLeaveById(Long id);

	Object deleteLeaveById(Long id);

}
