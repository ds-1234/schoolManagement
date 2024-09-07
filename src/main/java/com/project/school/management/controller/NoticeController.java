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
import com.project.school.management.entity.NoticeEntity;
import com.project.school.management.response.Response;
import com.project.school.management.service.NoticeService;

@CrossOrigin
@RestController
@RequestMapping("notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("getNoticeList")
	public ResponseEntity<Object> getNoticeList() {
		Response response = new Response();
		response.succeed();
		response.setData(noticeService.getList());
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("createNotice")
	public ResponseEntity<Response> createNotice(@RequestBody NoticeEntity dto) {
		Response response = new Response();
		response.succeed();
		response.setData(noticeService.save(dto));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getNotice/{id}")
	public ResponseEntity<Object> getClass(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(noticeService.getNotice(id));
		return ResponseEntity.ok().body(response);

	}

}
