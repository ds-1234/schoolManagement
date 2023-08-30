package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.Address;
import com.project.school.management.response.Response;
import com.project.school.management.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("address")
@Slf4j
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("createAddress")
	public ResponseEntity<Response> createAddress(@RequestBody Address dto) {
		log.info("******  API Start For save address******");
		Response response = new Response();
		response.succeed();
		response.setData(addressService.save(dto));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getAddressList")
	public ResponseEntity<Object> getAddressList() throws IOException {
		log.info("******  API Start For get address******");
		Response response = new Response();
		response.succeed();
		response.setData(addressService.getList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getAddress/{id}")
	public ResponseEntity<Object> getAddress(@PathVariable Long id) {
		log.info("******  API Start For get address by id******");
		Response response = new Response();
		response.succeed();
		response.setData(addressService.getAddress(id));
		return ResponseEntity.ok().body(response);

	}

}
