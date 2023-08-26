package com.project.school.management.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="transport_entity")
public class TransportEntity {
	
	@Id
	@Column(name="vehicle_number")
	private String vehicleNumber;
	
	@Column(name="route_name")
	private String routeName;
	
	@Column(name="driver_name")
	private String driverName;
	
	@Column(name="license_number")
	private String licenseNumber;
	
	@Column(name="contact_number")
	private Long contactNumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name = "created_on_date_time")
	private Date createdOnDateTime;
	
	@Column(name = "updated_on_date_time")
	private Date updatedOnDateTime;
	
	@Column(name="status")
	private boolean status;

}
