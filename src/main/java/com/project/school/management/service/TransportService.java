package com.project.school.management.service;

import java.util.*;

import com.project.school.management.dto.TransportRequestDto;
import com.project.school.management.entity.TransportEntity;

public interface TransportService {

	List<TransportEntity> getList();

	TransportEntity save(TransportEntity transport);

	TransportEntity getTransport(Long id);

	TransportEntity updateTransport(TransportRequestDto transportRequestDto);

	void changeStatus(Long id);

	Object deleteTransport(Long id);

}
