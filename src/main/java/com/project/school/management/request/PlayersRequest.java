package com.project.school.management.request;

import java.sql.Date;

import com.project.school.management.entity.MasterSportsEntity;
import com.project.school.management.entity.UserEntity;

import lombok.Data;

@Data
public class PlayersRequest {
	 Long id;
     UserEntity playersName;
	 MasterSportsEntity sportsName;
	 Date dateOfJoin;
	 Boolean isActive;

}
