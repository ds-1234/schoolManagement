package com.project.school.management.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.EventEntity;
import com.project.school.management.entity.HolidayEntity;
import com.project.school.management.entity.MasterLibrary;
import com.project.school.management.entity.MasterSports;
import com.project.school.management.entity.TransportEntity;
import com.project.school.management.service.ManagementService;

@RestController
@RequestMapping("/management")
public class ManagementController {
	
	private static final Logger log = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	private ManagementService managementService;
	
	@PostMapping("/saveHoliday")
	public ResponseEntity<Object> saveHoliday(@RequestBody HolidayEntity holidayEntity) throws IOException{
		log.info("******API Start For save holiday******");
				return managementService.saveHoliday(holidayEntity);	
	}
	
	@GetMapping("/getHoliday")
	public ResponseEntity<Object> getHoliday() throws IOException{
		log.info("******  API Start For get holiday******");
				return managementService.getHoliday();	
	}
	
	@PostMapping("/saveEvent")
	public ResponseEntity<Object> saveEvent(@RequestBody EventEntity eventEntity) throws IOException{
		log.info("******API Start For save event******");
				return managementService.saveEvent(eventEntity);	
	}
	
	@PostMapping("/addBookInLibrary")
	public ResponseEntity<Object> saveBookInLibrary(@RequestBody MasterLibrary masterLibrary) throws IOException{
		log.info("******API Start For save book in master library******");
				return managementService.addBookInLibrary(masterLibrary);	
	}
	
	@GetMapping("/getBookList")
	public ResponseEntity<Object> getBookList() throws IOException{
		log.info("******  API Start For get Library book******");
				return managementService.getBookList();	
	}
	
	@PostMapping("/addSports")
	public ResponseEntity<Object> saveSports(@RequestBody MasterSports masterSportsRequest) throws IOException{
		log.info("******API Start For master sports******");
				return managementService.saveSports(masterSportsRequest);	
	}
	
	@GetMapping("/getSportsList")
	public ResponseEntity<Object> getSportsList() throws IOException{
		log.info("******  API Start For get sports list******");
				return managementService.getSportsList();	
	}
	
	@GetMapping("/editSportsById")
	public ResponseEntity<Object> getSportsById(@RequestParam("id") String id) throws IOException{
		log.info("******  API Start For get sports by id******");
				return managementService.getSportsById(id);	
	}
	
	@PutMapping("/updateSports")
	public ResponseEntity<Object> updateSports(@RequestBody MasterSports updateSportsRequest) throws IOException{
		log.info("******API Start For update sports******");
				return managementService.updateSports(updateSportsRequest);	
	}
	
	@DeleteMapping("/deleteSports")
	public ResponseEntity<Object> deleteSports(@RequestParam("sportsId") String sportsId) throws IOException{
		log.info("******API Start For delete sports******");
				return managementService.deleteSports(sportsId);	
	}
	
	@PostMapping("/addTransport")
	public ResponseEntity<Object> saveTransport(@RequestBody TransportEntity transportEntity) throws IOException{
		log.info("******API Start For transport******");
				return managementService.saveTransport(transportEntity);	
	}

}
