package com.project.school.management.serviceImpl;

import java.security.DrbgParameters.NextBytes;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.TransportEntity;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.TransportRepository;
import com.project.school.management.service.TransportService;

@Service
public class TransportServiceImpl implements TransportService{
	
	@Autowired
	private TransportRepository transportRepository;

	@Override
	public List<TransportEntity> getList() {
		return this.transportRepository.findAll();
	}

	@Override
	public TransportEntity save(TransportEntity transport) {
		String transportId = generateTransportId(transport);
		transport.setTransportId(transportId);
		return this.transportRepository.save(transport);
	}

	private String generateTransportId(TransportEntity transport) {
		String first = transport.getVehicleNumber().substring(0, 2);
		String last = transport.getVehicleNumber().substring(transport.getVehicleNumber().length()-2);
		String combine = first +last;
		Random random = new Random();
		int randomNumber = 10 + random.nextInt(90);
		String generatedNumber = combine + randomNumber;
		return generatedNumber;
	}

	@Override
	public TransportEntity getTransport(Long id) {
		Optional<TransportEntity> dbData = this.transportRepository.findById(id);
		if(dbData.isPresent()) {
			return dbData.get();
		}
		throw new NotExist() ;
	}

}
