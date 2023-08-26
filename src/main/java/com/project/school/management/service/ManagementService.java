package com.project.school.management.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.project.school.management.entity.EventEntity;
import com.project.school.management.entity.HolidayEntity;
import com.project.school.management.entity.MasterLibrary;
import com.project.school.management.entity.MasterSports;
import com.project.school.management.entity.TransportEntity;

public interface ManagementService {

	ResponseEntity<Object> saveHoliday(HolidayEntity holidayEntity) throws IOException;

	ResponseEntity<Object> getHoliday() throws IOException;

	ResponseEntity<Object> saveEvent(EventEntity eventEntity) throws IOException;

	ResponseEntity<Object> addBookInLibrary(MasterLibrary masterLibrary) throws IOException;

	ResponseEntity<Object> getBookList() throws IOException;

	ResponseEntity<Object> saveSports(MasterSports masterSportsRequest) throws IOException;

	ResponseEntity<Object> getSportsList() throws IOException;

	ResponseEntity<Object> getSportsById(String sportsId) throws IOException;

	ResponseEntity<Object> updateSports(MasterSports updateSportsRequest) throws IOException;

	ResponseEntity<Object> deleteSports(String sportsId) throws IOException;

	ResponseEntity<Object> saveTransport(TransportEntity transportEntity) throws IOException;

}
