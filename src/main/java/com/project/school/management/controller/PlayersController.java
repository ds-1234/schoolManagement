package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.request.PlayersRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.PlayersService;

@CrossOrigin
@RestController
@RequestMapping("players")
public class PlayersController {
	
	@Autowired
	private PlayersService playersService;
	
	@PostMapping("savePlayers")
	public ResponseEntity<Response> savePlayers(@RequestBody PlayersRequest playersRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(playersService.savePlayers(playersRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getPlayersList")
	public ResponseEntity<Object> getPlayersList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(playersService.getPlayersList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getPlayersById/{id}")
	public ResponseEntity<Object> getPlayersById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(playersService.getPlayersById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deletePlayers/{id}")
	public ResponseEntity<Response> deletePlayers(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(playersService.deletePlayers(id));
		return ResponseEntity.ok().body(response);
	}


}
