package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.Address;

public interface AddressService {

	Address save(Address address);

	List<Address> getList();

	Address getAddress(Long id);

}
