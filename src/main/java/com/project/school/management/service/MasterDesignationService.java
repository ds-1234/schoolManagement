package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.MasterDesignationEntity;
import com.project.school.management.request.DesignationRequest;

public interface MasterDesignationService {

	MasterDesignationEntity saveDesignation(DesignationRequest designationRequest);

	List<MasterDesignationEntity> getDesignationList();

	MasterDesignationEntity getDesignationById(Long id);

	Object deleteDesignation(Long id);

}
