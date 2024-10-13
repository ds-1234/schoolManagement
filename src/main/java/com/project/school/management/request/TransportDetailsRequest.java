package com.project.school.management.request;

import lombok.Data;

@Data
public class TransportDetailsRequest {
	String userId;
	Long routeName;
	String pickupPoint;

}
