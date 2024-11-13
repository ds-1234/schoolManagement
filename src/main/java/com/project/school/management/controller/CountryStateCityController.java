package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.response.Response;
import com.project.school.management.service.CountryStateCityService;

@CrossOrigin
@RestController
@RequestMapping("area")
public class CountryStateCityController {
	
	@Autowired
	private CountryStateCityService countryStateCityService;
	
	@GetMapping("getCountryList")
	public ResponseEntity<Object> getCountryList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(countryStateCityService.getCountryList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getStateList/{id}")
	public ResponseEntity<Object> getStateList(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(countryStateCityService.getStateList(id));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getCitiesList/{id}")
	public ResponseEntity<Object> getCitiesList(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(countryStateCityService.getCitiesList(id));
		return ResponseEntity.ok().body(response);
	}

}
