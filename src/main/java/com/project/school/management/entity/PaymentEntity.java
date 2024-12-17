package com.project.school.management.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.dto.EmployeeDeductionFieldsDto;
import com.project.school.management.dto.EmployeeEarningFieldsDto;
import com.project.school.management.dto.EmployeePaySummaryDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "payment_entity")
public class PaymentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_table_id", nullable = false)
	private Long userTableId;
	
	@Column(name = "school_name", nullable = false)
	private String schoolName;
	
	@Column(name = "school_address", nullable = false)
	private String schoolAddress;
	
	@Column(name = "school_city", nullable = false)
	private String schoolCity;
	
	@Column(name = "school_pincode", nullable = false)
	private String schoolPincode;
	
	@Column(name = "school_country", nullable = false)
	private String schoolCountry;
	
	@Column(name = "emp_name", nullable = false)
	private String empName;
	
	@Column(name = "pay_period", nullable = false)
	private String payPeriod;
	
	@Column(name = "loss_of_paydays", nullable = false)
	private Double lossOfPaydays;
	
	@Column(name = "employee_id", nullable = false)
	private String employeeId;
	
	@Column(name = "paid_days", nullable = false)
	private Double paidDays;
	
	@Column(name = "pay_date", nullable = false)
	private Date payDate;
	
	@Column(name = "date_of_joining", nullable = false)
	private Date dateOfJoining;
	
	@Column(name = "designation", nullable = false)
	private String designation;
	
	@Column(name = "department", nullable = false)
	private String department;
	
	@Lob
	@Column(name = "pay_summary_field_list")
	private String paySummaryFieldList;
	
	
	@Column(name = "basic_pay_earning", nullable = false)
	private String basicPayEarning;
	
	@Column(name = "house_rent_allow_earning")
	private String houseRentAllowEarning;
	
	@Column(name = "special_pay_allowance")
	private String specialPayAllowance;
	
	@Column(name = "over_time_pay")
	private String overTimePay;
	
	@Lob
	@Column(name = "earning_fields_list")
	private String earningFieldsList;
	
	@Column(name = "gross_salary", nullable = false)
	private String grossSalary;
	
	
	@Column(name = "income_tax_deduction")
	private String incomeTaxDeduction;
	
	@Column(name = "pf_deduction")
	private String pfDeduction;
	
	@Column(name = "gratuity_deduction")
	private String gratuityDeduction;
	
	@Column(name = "professional_tax")
	private String professionalTax;
	
	@Column(name = "advance_pay")
	private String advancePay;
	
	@Lob
	@Column(name = "deduction_fields_list")
	private String deductionFieldsList;
	
	@Column(name = "total_deduction", nullable = false)
	private String totalDeduction;
	
	
	@Column(name = "total_net_pay", nullable = false)
	private String totalNetPay;
	
	@Column(name = "net_pay_amount_in_words", nullable = false)
	private String netPayAmountInWords;
	
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "branch_name")
	private String branchName;
	
	@Column(name = "employer_signature_text")
	private String employerSignatureText;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	public List<EmployeeDeductionFieldsDto> getDeductionList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(deductionFieldsList, objectMapper.getTypeFactory().constructCollectionType(List.class, EmployeeDeductionFieldsDto.class));
    }

    // Setter for the List of DTOs (Serializing the List into JSON string)
    public void setDeductionList(List<EmployeeDeductionFieldsDto> dtoList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.deductionFieldsList = objectMapper.writeValueAsString(dtoList);  // Serialize the list to JSON
    }
    
    public List<EmployeeEarningFieldsDto> getEarningList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(earningFieldsList, objectMapper.getTypeFactory().constructCollectionType(List.class, EmployeeEarningFieldsDto.class));
    }

    // Setter for the List of DTOs (Serializing the List into JSON string)
    public void setEarningList(List<EmployeeEarningFieldsDto> dtoList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.earningFieldsList = objectMapper.writeValueAsString(dtoList);  // Serialize the list to JSON
    }
    
    public List<EmployeePaySummaryDto> getPaySummaryList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(paySummaryFieldList, objectMapper.getTypeFactory().constructCollectionType(List.class, EmployeePaySummaryDto.class));
    }

    // Setter for the List of DTOs (Serializing the List into JSON string)
    public void setPaySummaryList(List<EmployeePaySummaryDto> dtoList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.paySummaryFieldList = objectMapper.writeValueAsString(dtoList);  // Serialize the list to JSON
    }

}
