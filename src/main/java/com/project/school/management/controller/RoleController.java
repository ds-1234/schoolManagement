package com.project.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.constant.Message;
import com.project.school.management.entity.Role;
import com.project.school.management.response.Response;
import com.project.school.management.service.RoleService;

@CrossOrigin
@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping("createRole")
	public ResponseEntity<Response> createRole(@RequestBody Role dto) {
		Response response = new Response();
		response.succeed();
		response.setData(roleService.save(dto));
		response.setMessage(Message.ROLE_CREATED_SUCCESSFULLY);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getRoleList")
	public ResponseEntity<Object> getRoleList() {
		Response response = new Response();
		response.succeed();
		response.setData(roleService.getList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getRole/{id}")
	public ResponseEntity<Object> getRole(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(roleService.getRole(id));
		return ResponseEntity.ok().body(response);

	}

}
