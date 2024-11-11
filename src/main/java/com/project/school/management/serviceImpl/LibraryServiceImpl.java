package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.school.management.entity.LibraryEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.LibraryRepository;
import com.project.school.management.request.BookIssueRequest;
import com.project.school.management.service.LibraryService;
import com.project.school.management.utility.Utils;
@Service
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private Utils utils;
	
	public LibraryServiceImpl(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public LibraryEntity saveBookIssued(BookIssueRequest bookIssueRequest) throws IOException {
		LibraryEntity entity = new LibraryEntity();
		if(!Objects.isNull(bookIssueRequest.getId())) {
			if(!Objects.isNull(bookIssueRequest.getIssuedDate()) ||(!Objects.isNull(bookIssueRequest.getReturnDate()))) {
				LibraryEntity dbData = libraryRepository.findById(bookIssueRequest.getId())
						.orElseThrow(()-> new InvalidArgumentException("Given request is invalid"));
				objectMapper.updateValue(dbData, bookIssueRequest);
				return libraryRepository.save(dbData);
			}
		}else {
			entity = objectMapper.convertValue(bookIssueRequest, LibraryEntity.class);
			Long lastId = libraryRepository.findMaxId();
			long newId = (lastId == null || lastId == 0) ? 1 : lastId + 1;
			entity.setId(newId);
			String bookId = utils.generateRandomId();
			entity.setIssueId("LB"+bookId);
			
		}
		return libraryRepository.save(entity);
	}

	@Override
	public Map<String, List<LibraryEntity>> getBookIssued() throws IOException {
		List<LibraryEntity> entity = libraryRepository.findAllByOrderByIssuedDateDesc();
		Map<String, List<LibraryEntity>> groupedByUserId = entity.stream()
		        .collect(Collectors.groupingBy(LibraryEntity::getUserId));
		return groupedByUserId;
	}

	@Override
	public LibraryEntity getBookIssuedById(Long id) throws IOException {
		return libraryRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Data not present by given id"));
	}

}
