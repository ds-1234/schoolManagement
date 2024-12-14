package com.project.school.management.request;

import java.util.List;

import com.project.school.management.dto.LeaveCounterDto;

import lombok.Data;

@Data
public class HrmDetailsDto {
	
	Long teacherId;
	String epfNumber;
	String basicSalary;
	String contractType;
	String workShift;
	String workLocation;
	String employeeNumber;
	List<LeaveCounterDto> leaveCounterDto;

}
