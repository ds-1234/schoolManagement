package com.project.school.management.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.school.management.entity.PaymentEntity;
import com.project.school.management.entity.UserLeaveCounterEntity;
import com.project.school.management.request.HrmDetailsDto;
import com.project.school.management.request.PaySlipRequest;
import com.project.school.management.response.PaySlipListResponse;

public interface HrmService {

	HrmDetailsDto saveHrmDetails(HrmDetailsDto hrmDetailsDto);

	List<UserLeaveCounterEntity> getLeaveCounterDetailsById(Long staffId);

	PaymentEntity paySlipCreator(PaySlipRequest paySlipRequest) throws JsonProcessingException;

	List<PaymentEntity> getPaySlipById(String staffId, String payPeriod) throws JsonProcessingException;

	List<PaySlipListResponse> getPaySlipListById(String staffId) throws JsonProcessingException;

}
