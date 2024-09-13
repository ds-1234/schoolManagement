package com.project.school.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransportRequestDto {
	private Long id;
	private String routeName;
	private String vehicleNumber;
	private String driverName;
	private String licenseNumber;
	private String phone;

}
