package com.project.school.management.serviceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.HolidayEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.HolidayRepository;
import com.project.school.management.request.HolidayRequest;
import com.project.school.management.service.HolidayService;
import com.project.school.management.utility.Utils;
@Service
public class HolidayServiceImpl implements HolidayService{
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private HolidayRepository holidayRepository;

	@Override
	public HolidayEntity saveholiday(HolidayRequest holidayRequest) {
		HolidayEntity entity = new HolidayEntity();
		if(Objects.isNull(holidayRequest.getId())) {
			String holidayName = utils.capitalizeFirstCharacter(holidayRequest.getHolidayName());
			entity.setHolidayName(holidayName);
			
			String generateHolidayId = utils.generateRandomId();
			entity.setHolidayId("HL"+generateHolidayId);
			
			entity.setHolidayDate(holidayRequest.getHolidayDate());
			entity.setDescription(holidayRequest.getDescription());
			entity.setIsActive(holidayRequest.getIsActive());
			return this.holidayRepository.save(entity);
		}else {
			HolidayEntity dbData = holidayRepository.findById(holidayRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("given id is invalid"));
			String holidayName = utils.capitalizeFirstCharacter(holidayRequest.getHolidayName());
			dbData.setHolidayName(holidayName);
			dbData.setHolidayDate(holidayRequest.getHolidayDate());
			dbData.setDescription(holidayRequest.getDescription());
			dbData.setIsActive(holidayRequest.getIsActive());
			return this.holidayRepository.save(dbData);
		}
	}

	@Override
	public List<HolidayEntity> getHolidaysList() {
		List<HolidayEntity> data = holidayRepository.findAll();
		data.sort(Comparator.comparingLong(entity -> entity.getId()));
		return data;

	}

	@Override
	public HolidayEntity getHolidayById(Long id) {
		HolidayEntity dbData = holidayRepository.findById(id)
				.orElseThrow(()->new InvalidArgumentException("Given id is invalid or empty"));
		return dbData;
	}

	@Override
	public Object deleteholidays(Long id) {
		HolidayEntity dbData = holidayRepository.findById(id)
				.orElseThrow(()->new InvalidArgumentException("Given id is invalid or empty"));
		holidayRepository.delete(dbData);
		return dbData.getHolidayName()+" holiday deleted Successfully";
	}

}
