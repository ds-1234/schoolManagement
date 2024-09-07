package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.Role;

public interface RoleService {

	Role save(Role address);

	List<Role> getList();

	Role getRole(Long id);

}
