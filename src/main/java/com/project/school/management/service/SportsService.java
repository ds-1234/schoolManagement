package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.MasterSportsEntity;
import com.project.school.management.request.SportsRequest;

public interface SportsService {

	MasterSportsEntity saveSports(SportsRequest sportsRequest);

	List<MasterSportsEntity> getSportsList();

	MasterSportsEntity getSportsById(Long id);

	Object deleteSports(Long id);

}
