package com.project.school.management.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.project.school.management.entity.LibraryEntity;
import com.project.school.management.request.BookIssueRequest;

public interface LibraryService {

	LibraryEntity saveBookIssued(BookIssueRequest bookIssueRequest) throws IOException;

	Map<String, List<LibraryEntity>> getBookIssued() throws IOException;

	LibraryEntity getBookIssuedById(Long id) throws IOException;

}
