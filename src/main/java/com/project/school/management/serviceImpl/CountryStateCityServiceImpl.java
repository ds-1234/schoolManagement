package com.project.school.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.CitiesEntity;
import com.project.school.management.entity.CountryEntity;
import com.project.school.management.entity.StateEntity;
import com.project.school.management.repository.CitiesRepository;
import com.project.school.management.repository.CountryRepository;
import com.project.school.management.repository.StateRepository;
import com.project.school.management.service.CountryStateCityService;
@Service
public class CountryStateCityServiceImpl implements CountryStateCityService{
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CitiesRepository cityRepo;

	@Override
	public List<CountryEntity> getCountryList() {
		return countryRepo.findAll();
	}

	@Override
	public List<StateEntity> getStateList(Long id) {
		return stateRepo.findByCountryId(id);
	}

	@Override
	public List<CitiesEntity> getCitiesList(Long id) {
		return cityRepo.findByStateId(id);
	}

}
