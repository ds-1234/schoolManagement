package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.Role;
import com.project.school.management.exception.DataNotExist;
import com.project.school.management.repository.RoleRepository;
import com.project.school.management.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role address) {
		return this.roleRepository.save(address);
	}

	@Override
	public List<Role> getList() {
		return this.roleRepository.findAll();
	}

	@Override
	public Role getAddress(Long id) {
		Optional<Role> data = this.roleRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}
		throw new DataNotExist();
	}

}
