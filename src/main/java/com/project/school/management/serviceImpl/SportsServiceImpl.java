package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.MasterSportsEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.SportsRepository;
import com.project.school.management.request.SportsRequest;
import com.project.school.management.service.SportsService;
import com.project.school.management.utility.Utils;

@Service
public class SportsServiceImpl implements SportsService{
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private SportsRepository sportsRepository;

	@Override
	public MasterSportsEntity saveSports(SportsRequest sportsRequest) {
		MasterSportsEntity entity = new MasterSportsEntity();
		if(Objects.isNull(sportsRequest.getId())){
			String sportsId = utils.generateRandomId();
			entity.setSportsId("SP"+sportsId);
			
			String sportsName = utils.capitalizeFirstCharacter(sportsRequest.getSportsName());
			entity.setSportsName(sportsName);
			
			entity.setUserId(sportsRequest.getUserId());
			entity.setStartedYear(sportsRequest.getStartedYear());
			entity.setIsActive(sportsRequest.getIsActive());
			return sportsRepository.save(entity);
		}else {
			MasterSportsEntity dbdata = sportsRepository.findById(sportsRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given id is invalid"));
			String sportsName = utils.capitalizeFirstCharacter(sportsRequest.getSportsName());
			dbdata.setSportsName(sportsName);
			
			dbdata.setUserId(sportsRequest.getUserId());
			dbdata.setStartedYear(sportsRequest.getStartedYear());
			dbdata.setIsActive(sportsRequest.getIsActive());
			return sportsRepository.save(dbdata);
		}
	}

	@Override
	public List<MasterSportsEntity> getSportsList() {
		return this.sportsRepository.findAll();
	}

	@Override
	public MasterSportsEntity getSportsById(Long id) {
		MasterSportsEntity dbdata = sportsRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or empty"));
		return dbdata;
	}

	@Override
	public Object deleteSports(Long id) {
		MasterSportsEntity dbdata = sportsRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or empty"));
		sportsRepository.delete(dbdata);
		return dbdata.getSportsName()+" is deleted successfully";
	}

}
