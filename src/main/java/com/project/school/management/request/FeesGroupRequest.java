package com.project.school.management.request;

import lombok.Data;

@Data
public class FeesGroupRequest {

	Long id;

	String feesGroupName;

	String description;

	Boolean isActive;

}
