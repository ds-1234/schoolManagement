package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.MasterDepartmentEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.MasterDepartmentRepository;
import com.project.school.management.request.DepartmentRequest;
import com.project.school.management.service.MasterDepartmentService;
import com.project.school.management.utility.Utils;
@Service
public class MasterDepartmentServiceImpl implements MasterDepartmentService{
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private MasterDepartmentRepository masterDepartmentRepository;

	@Override
	public MasterDepartmentEntity saveDepartment(DepartmentRequest departmentRequest) {
		MasterDepartmentEntity entity = new MasterDepartmentEntity();
		if(Objects.isNull(departmentRequest.getId())) {
			String departmentId = utils.generateRandomId();
			entity.setDepartmentName(departmentRequest.getDepartmentName().toUpperCase());
			entity.setDepartmentId("DP"+departmentId);
			entity.setIsActive(departmentRequest.getIsActive());
			return masterDepartmentRepository.save(entity);
		}else {
			MasterDepartmentEntity dbDepartmentEntity = masterDepartmentRepository.findById(departmentRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given id is invalid"));
			dbDepartmentEntity.setDepartmentName(departmentRequest.getDepartmentName().toUpperCase());
			dbDepartmentEntity.setIsActive(departmentRequest.getIsActive());
			return masterDepartmentRepository.save(dbDepartmentEntity);
		}
	}

	@Override
	public List<MasterDepartmentEntity> getDepartmentList() {
		return masterDepartmentRepository.findAll();
	}

	@Override
	public MasterDepartmentEntity getDepartmentById(Long id) {
		MasterDepartmentEntity dbDepartmentEntity = masterDepartmentRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid"));
		
		return dbDepartmentEntity;
	}

	@Override
	public Object deleteDepartment(Long id) {
		MasterDepartmentEntity dbDepartmentEntity = masterDepartmentRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given id is invalid or empty"));
		masterDepartmentRepository.delete(dbDepartmentEntity);
		return dbDepartmentEntity.getDepartmentName()+ " is deleted successfully.";
	}

}
