package com.project.school.management.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
@Data
@Embeddable
public class AttendanceStatus {
	private Long studentId;
    private Long attendanceStatusId;

}
