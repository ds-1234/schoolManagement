package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.MasterDepartmentEntity;
import com.project.school.management.request.DepartmentRequest;

public interface MasterDepartmentService {

	MasterDepartmentEntity saveDepartment(DepartmentRequest departmentRequest);

	List<MasterDepartmentEntity> getDepartmentList();

	MasterDepartmentEntity getDepartmentById(Long id);

	Object deleteDepartment(Long id);

}
