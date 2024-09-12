package com.ugurhmz.springThymeleaf.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugurhmz.springThymeleaf.entity.Player;
import com.ugurhmz.springThymeleaf.repository.PlayerRepository;



@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepo;
	
	
	// LIST ALL PLAYERS
	public List<Player> listAllPlayers() {
		return (List<Player>) playerRepo.findAll();
	}
	
	
	
	// CREATE & UPDATE
	public Player save(Player player) {
		
		boolean isUpdatingPlayer = (player.getPlayerId() != null);
		
		
		if(isUpdatingPlayer) {
			Player playerExisting = playerRepo.findById(player.getPlayerId()).get();
		}
	
		return playerRepo.save(player);
		
	}

	
	// Get user Id
	public Player getUser(Integer playerId) throws UserNotFoundException {
	
		try {
			return playerRepo.findById(playerId).get();
			
		} catch(NoSuchElementException ex) {
			throw new UserNotFoundException("Could not find any user with ID : "+playerId);
		}
	}
	
		
		
		
	// Delete User
	public void  delete(Integer playerId) throws UserNotFoundException {
		Long countById = playerRepo.countByplayerId(playerId);
		
		if(countById == null || countById == 0) {
			throw new UserNotFoundException("Could not find any user with ID : "+playerId);
		}
		
		playerRepo.deleteById(playerId);
	}
	
		

	
	
	
	
	
	
}
