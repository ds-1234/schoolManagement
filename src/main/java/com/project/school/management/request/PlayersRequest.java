package com.project.school.management.request;

import java.sql.Date;

import com.project.school.management.entity.MasterSportsEntity;

import lombok.Data;

@Data
public class PlayersRequest {
	 Long id;
     Long userId;
	 MasterSportsEntity sportsName;
	 Date dateOfJoin;
	 Boolean isActive;

}
