package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.Section;
import com.project.school.management.exception.DataNotExist;
import com.project.school.management.repository.SectionRepository;
import com.project.school.management.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionRepository sectionRepository;

	@Override
	public Section save(Section section) {
		return this.sectionRepository.save(section);
	}

	@Override
	public List<Section> getList() {
		return this.sectionRepository.findAll();
	}

	@Override
	public Section getAddress(Long id) {
		Optional<Section> data = this.sectionRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}
		throw new DataNotExist();
	}

}
