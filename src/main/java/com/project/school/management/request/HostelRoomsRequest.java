package com.project.school.management.request;

import java.math.BigDecimal;

import com.project.school.management.entity.HostelEntity;
import com.project.school.management.entity.RoomTypeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HostelRoomsRequest {

	Long id;

	String hostelRoomNumber;

	HostelEntity hostelName;

	RoomTypeEntity roomType;

	Long numOfBeds;

	BigDecimal costPerBed;

	Boolean isActive;

}
