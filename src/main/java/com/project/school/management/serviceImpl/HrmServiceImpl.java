package com.project.school.management.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.school.management.dto.EmployeeDeductionFieldsDto;
import com.project.school.management.dto.LeaveCounterDto;
import com.project.school.management.entity.PaymentEntity;
import com.project.school.management.entity.TeacherInfoEntity;
import com.project.school.management.entity.UserLeaveCounterEntity;
import com.project.school.management.repository.LeaveCounterRepository;
import com.project.school.management.repository.PaymentRepository;
import com.project.school.management.repository.TeacherInfoRepository;
import com.project.school.management.request.HrmDetailsDto;
import com.project.school.management.request.PaySlipRequest;
import com.project.school.management.response.PaySlipListResponse;
import com.project.school.management.service.HrmService;
@Service
public class HrmServiceImpl implements HrmService{
	
	@Autowired
	private TeacherInfoRepository teacherInfoRepository;
	
	@Autowired
	private LeaveCounterRepository leaveCounterRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public HrmDetailsDto saveHrmDetails(HrmDetailsDto hrmDetailsDto) {
		TeacherInfoEntity entity = teacherInfoRepository.findByTeacherId(hrmDetailsDto.getTeacherId().toString());
		entity.setBasicSalary(hrmDetailsDto.getBasicSalary());
		entity.setContractType(hrmDetailsDto.getContractType());
		entity.setEmployeeNumber(hrmDetailsDto.getEmployeeNumber());
		entity.setEpfNumber(hrmDetailsDto.getEpfNumber());
		entity.setWorkLocation(hrmDetailsDto.getWorkLocation());
		entity.setWorkShift(hrmDetailsDto.getWorkShift());
		entity.setDateOfJoining(hrmDetailsDto.getDateOfJoining());
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

	@Override
	public PaymentEntity paySlipCreator(PaySlipRequest paySlipRequest) throws JsonProcessingException{
		PaymentEntity entity = new PaymentEntity();
		entity.setAccountNumber(paySlipRequest.getAccountNumber());
		entity.setAdvancePay(paySlipRequest.getAdvancePay());
		entity.setBankName(paySlipRequest.getBankName());
		entity.setBasicPayEarning(paySlipRequest.getBasicPayEarning());
		entity.setBranchName(paySlipRequest.getBranchName());
		entity.setCreatedDate(LocalDate.now());
		entity.setDateOfJoining(paySlipRequest.getDateOfJoining());
		entity.setDeductionList(paySlipRequest.getDeductionFieldsList());
		//entity.setDeductionFieldsList(paySlipRequest.getDeductionFieldsList());
		entity.setDepartment(paySlipRequest.getDepartment());
		entity.setDesignation(paySlipRequest.getDesignation());
		entity.setEarningList(paySlipRequest.getEarningFieldsList());
//		entity.setEarningFieldsList(paySlipRequest.getEarningFieldsList());
		entity.setEmployeeId(paySlipRequest.getEmployeeId());
		entity.setEmployerSignatureText(paySlipRequest.getEmployerSignatureText());
		entity.setEmpName(paySlipRequest.getEmpName());
		entity.setGratuityDeduction(paySlipRequest.getGratuityDeduction());
		entity.setGrossSalary(paySlipRequest.getGrossSalary());
		entity.setHouseRentAllowEarning(paySlipRequest.getHouseRentAllowEarning());
		entity.setIncomeTaxDeduction(paySlipRequest.getIncomeTaxDeduction());
		entity.setLossOfPaydays(paySlipRequest.getLossOfPaydays());
		entity.setNetPayAmountInWords(paySlipRequest.getNetPayAmountInWords());
		entity.setOverTimePay(paySlipRequest.getOverTimePay());
		entity.setPaidDays(paySlipRequest.getPaidDays());
		entity.setPayDate(paySlipRequest.getPayDate());
		entity.setPayPeriod(paySlipRequest.getPayPeriod());
		entity.setPaySummaryList(paySlipRequest.getPaySummaryFieldList());
//		entity.setPaySummaryFieldList(paySlipRequest.getPaySummaryFieldList());
		entity.setPfDeduction(paySlipRequest.getPfDeduction());
		entity.setProfessionalTax(paySlipRequest.getProfessionalTax());
		entity.setSchoolAddress(paySlipRequest.getSchoolAddress());
		entity.setSchoolCity(paySlipRequest.getSchoolCity());
		entity.setSchoolCountry(paySlipRequest.getSchoolCountry());
		entity.setSchoolName(paySlipRequest.getSchoolName());
		entity.setSchoolPincode(paySlipRequest.getSchoolPincode());
		entity.setSpecialPayAllowance(paySlipRequest.getSpecialPayAllowance());
		entity.setTotalDeduction(paySlipRequest.getTotalDeduction());
		entity.setTotalNetPay(paySlipRequest.getTotalNetPay());
		entity.setUserTableId(paySlipRequest.getUserTableId());
		return paymentRepository.save(entity);
	}

	@Override
	public List<PaymentEntity> getPaySlipById(String staffId, String payPeriod) throws JsonProcessingException {
		return paymentRepository.findAllByUserTableIdAndPayPeriod(staffId, payPeriod);
	}

	@Override
	public List<PaySlipListResponse> getPaySlipListById(String staffId) throws JsonProcessingException {
		List<PaySlipListResponse> responseList = paymentRepository.findAllByUserTableId(staffId).stream()
		        .map(entity -> {
		            PaySlipListResponse response = new PaySlipListResponse();
		            response.setId(entity.getId());
		            response.setPayPeriod(entity.getPayPeriod());
		            return response;
		        })
		        .sorted((response1, response2) -> Long.compare(response2.getId(), response1.getId()))  // Sort by ID in descending order
		        .collect(Collectors.toList());

		    // Check if the response list is empty and add a default response message
		    if (responseList.isEmpty()) {
		        PaySlipListResponse noDataResponse = new PaySlipListResponse();
		        noDataResponse.setId(null);  // Or any default value
		        noDataResponse.setPayPeriod("No salary slip available");
		        responseList.add(noDataResponse);  // Add the "no data" message as a response
		    }

		    return responseList;
	}

	@Override
	public List<PaymentEntity> getPaySlipList() throws JsonProcessingException {
		return paymentRepository.findAll();
	}

}
