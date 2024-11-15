package com.project.school.management.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.project.school.management.entity.LibraryEntity;
import com.project.school.management.request.BookIssueRequest;
import com.project.school.management.response.BookIssuedResponse;

public interface LibraryService {

	LibraryEntity saveBookIssued(BookIssueRequest bookIssueRequest) throws IOException;

	Map<String, BookIssuedResponse> getBookIssued() throws IOException;

	LibraryEntity getBookIssuedById(Long id) throws IOException;

}
