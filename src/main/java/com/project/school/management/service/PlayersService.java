package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.PlayersEntity;
import com.project.school.management.request.PlayersRequest;

public interface PlayersService {

	PlayersEntity savePlayers(PlayersRequest playersRequest);

	List<PlayersEntity> getPlayersList();

	PlayersEntity getPlayersById(Long id);

	Object deletePlayers(Long id);

}
