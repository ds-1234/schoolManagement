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

import com.project.school.management.entity.Book;
import com.project.school.management.response.Response;
import com.project.school.management.service.BookService;

@CrossOrigin
@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("createBook")
	public ResponseEntity<Response> createBook(@RequestBody Book dto) {
		Response response = new Response();
		response.succeed();
		response.setData(bookService.save(dto));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getBookList")
	public ResponseEntity<Object> getBookList() {
		Response response = new Response();
		response.succeed();
		response.setData(bookService.getList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getBook/{id}")
	public ResponseEntity<Object> getBook(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(bookService.getAddress(id));
		return ResponseEntity.ok().body(response);

	}

}
