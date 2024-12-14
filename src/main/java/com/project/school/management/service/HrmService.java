package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.UserLeaveCounterEntity;
import com.project.school.management.request.HrmDetailsDto;

public interface HrmService {

	HrmDetailsDto saveHrmDetails(HrmDetailsDto hrmDetailsDto);

	List<UserLeaveCounterEntity> getLeaveCounterDetailsById(Long staffId);

}
