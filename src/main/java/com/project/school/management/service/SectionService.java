package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.Section;

public interface SectionService {

	Section save(Section section);

	List<Section> getList();

	Section getAddress(Long id);

}
