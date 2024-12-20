package com.project.school.management.request;

import java.sql.Date;
import java.util.List;

import com.project.school.management.dto.EmployeeDeductionFieldsDto;
import com.project.school.management.dto.EmployeeEarningFieldsDto;
import com.project.school.management.dto.EmployeePaySummaryDto;

import lombok.Data;

@Data
public class PaySlipRequest {
	String userTableId;
	String schoolName;
	String schoolAddress;
	String schoolCity;
	String schoolPincode;
	String schoolCountry;
	
	String empName;
	String payPeriod;
	Double lossOfPaydays;
	String employeeId;
	Double paidDays;
	Date payDate;
	Date dateOfJoining;
	String designation;
	String department;
	List<EmployeePaySummaryDto> paySummaryFieldList;
	
	String basicPayEarning;
	String houseRentAllowEarning;
	String specialPayAllowance;
	String overTimePay;
	List<EmployeeEarningFieldsDto> earningFieldsList;
	String grossSalary;
	
	String incomeTaxDeduction;
	String pfDeduction;
	String gratuityDeduction;
	String professionalTax;
	String advancePay;
	List<EmployeeDeductionFieldsDto> deductionFieldsList;
	String totalDeduction;
	
	String totalNetPay;
	String netPayAmountInWords;
	
	String accountNumber;
	String bankName;
	String branchName;
	String employerSignatureText;

}
