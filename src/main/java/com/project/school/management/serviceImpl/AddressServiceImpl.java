package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.Address;
import com.project.school.management.exception.DataNotExist;
import com.project.school.management.repository.AddressRepository;
import com.project.school.management.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address save(Address address) {
		return this.addressRepository.save(address);
	}

	@Override
	public List<Address> getList() {
		return this.addressRepository.findAll();
	}

	@Override
	public Address getAddress(Long id) {
		Optional<Address> data = this.addressRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}
		throw new DataNotExist();
	}

}
