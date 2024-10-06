package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.PlayersEntity;
import com.project.school.management.exception.InvalidArgumentException;
import com.project.school.management.repository.PlayersRepository;
import com.project.school.management.request.PlayersRequest;
import com.project.school.management.service.PlayersService;
import com.project.school.management.utility.Utils;
@Service
public class PlayersServiceImpl implements PlayersService{
	@Autowired
	private Utils utils;
	
	@Autowired
	private PlayersRepository playersRepository;

	@Override
	public PlayersEntity savePlayers(PlayersRequest playersRequest) {
		PlayersEntity entity = new PlayersEntity();
		if(Objects.isNull(playersRequest.getId())) {
			String playerId = utils.generateRandomId();
			entity.setPlayersId("PL"+playerId);
			
			entity.setUserId(playersRequest.getUserId());
			entity.setSportsName(playersRequest.getSportsName());
			entity.setDateOfJoin(playersRequest.getDateOfJoin());
			entity.setIsActive(playersRequest.getIsActive());
			return this.playersRepository.save(entity);
		}else {
			PlayersEntity dbData = playersRepository.findById(playersRequest.getId())
					.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid"));
			dbData.setUserId(playersRequest.getUserId());
			dbData.setSportsName(playersRequest.getSportsName());
			dbData.setDateOfJoin(playersRequest.getDateOfJoin());
			dbData.setIsActive(playersRequest.getIsActive());
			return this.playersRepository.save(dbData);
		}
	}

	@Override
	public List<PlayersEntity> getPlayersList() {
		return this.playersRepository.findAll();
	}

	@Override
	public PlayersEntity getPlayersById(Long id) {
		PlayersEntity dbData = playersRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid or empty"));
		return dbData;
	}

	@Override
	public Object deletePlayers(Long id) {
		PlayersEntity dbData = playersRepository.findById(id)
				.orElseThrow(()-> new InvalidArgumentException("Given Id is invalid or empty"));
		playersRepository.delete(dbData);
		return dbData.getPlayersId()+" is deleted successfully";
	}

}
