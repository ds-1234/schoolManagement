package com.project.school.management.service;

import java.io.IOException;
import java.util.List;

import com.project.school.management.entity.FeesGroupEntity;
import com.project.school.management.request.FeesGroupRequest;

public interface FeesGroupService {

	FeesGroupEntity saveFeesGroup(FeesGroupRequest feesGroupRequest) throws IOException;

	List<FeesGroupEntity> getFeesGroupList();

	FeesGroupEntity getFeesGroupById(Long id);

}
