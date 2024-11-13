package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.CitiesEntity;
import com.project.school.management.entity.CountryEntity;
import com.project.school.management.entity.StateEntity;

public interface CountryStateCityService {

	List<CountryEntity> getCountryList();

	List<StateEntity> getStateList(Long id);

	List<CitiesEntity> getCitiesList(Long id);

}
