package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.HostelEntity;
import com.project.school.management.request.HostelRequest;

public interface HostelService {

	HostelEntity saveHostel(HostelRequest hostelRequest);

	List<HostelEntity> getHostelList();

	HostelEntity getHostelById(Long id);

	Object deleteHostel(Long id);

}
