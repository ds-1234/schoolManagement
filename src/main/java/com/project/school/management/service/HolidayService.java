package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.HolidayEntity;
import com.project.school.management.request.HolidayRequest;

public interface HolidayService {

	HolidayEntity saveholiday(HolidayRequest holidayRequest);

	List<HolidayEntity> getHolidaysList();

	HolidayEntity getHolidayById(Long id);

	Object deleteholidays(Long id);

}
