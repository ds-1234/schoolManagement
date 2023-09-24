package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.constant.Message;
import com.project.school.management.entity.Role;
import com.project.school.management.exception.AlreadyExistException;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.RoleRepository;
import com.project.school.management.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		if (ObjectUtils.isNotEmpty(this.roleRepository.findByNameIgnoreCase(role.getName()))) {
			throw new AlreadyExistException(Message.ROLE_ALREADY_EXIST);
		}
		return this.roleRepository.save(role);
	}

	@Override
	public List<Role> getList() {
		return this.roleRepository.findAll();
	}

	@Override
	public Role getRole(Long id) {
		Optional<Role> data = this.roleRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}
		throw new NotExist(Message.ROLE_NOT_EXIST);
	}

}
