package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.Book;

public interface BookService {

	Book save(Book book);

	List<Book> getList();

	Book getAddress(Long id);

}
