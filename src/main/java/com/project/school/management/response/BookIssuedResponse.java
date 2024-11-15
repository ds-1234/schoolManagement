package com.project.school.management.response;

import java.util.List;

import com.project.school.management.entity.LibraryEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class BookIssuedResponse {
	private List<LibraryEntity> books;
    private long issuedCount;
    private long returnedCount;

}
