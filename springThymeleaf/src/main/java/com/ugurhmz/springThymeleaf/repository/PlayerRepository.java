package com.ugurhmz.springThymeleaf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ugurhmz.springThymeleaf.entity.Player;



@Repository
public interface PlayerRepository  extends CrudRepository<Player, Integer>{

	
	public Long countByplayerId(Integer playerId);
	
}
