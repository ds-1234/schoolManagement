package com.project.school.management.service;

import java.io.IOException;
import java.util.List;

import com.project.school.management.entity.FeesCollectionEntity;
import com.project.school.management.request.FeesCollectionRequest;

public interface FeesCollectionService {

	FeesCollectionEntity savefeesCollection(FeesCollectionRequest feesCollectionRequest) throws IOException;

	List<FeesCollectionEntity> getFeesCollectionList();

	FeesCollectionEntity getFeesCollectionById(Long id);

}
