package com.project.school.management.service;

import java.util.*;

import com.project.school.management.entity.TransportEntity;

public interface TransportService {

	List<TransportEntity> getList();

	TransportEntity save(TransportEntity transport);

	TransportEntity getTransport(Long id);

}
