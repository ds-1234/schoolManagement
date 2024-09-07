package com.project.school.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "transport")
public class TransportEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "transport_id", nullable = false)
	private String transportId;
	
	@Column(name = "route_name", nullable = false)
	private String routeName;
	
	@Column(name = "vehicle_number", nullable = false)
	private String vehicleNumber;
	
	@Column(name = "driver_name", nullable = false)
	private String driverName;
	
	@Column(name = "license_number", nullable = false)
	private String licenseNumber;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "isActive", nullable = false)
	private Boolean isActive;

}
