package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.Book;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.BookRepository;
import com.project.school.management.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book save(Book book) {
		return this.bookRepository.save(book);
	}

	@Override
	public List<Book> getList() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book getAddress(Long id) {
		Optional<Book> data = this.bookRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}
		throw new NotExist();
	}

}
