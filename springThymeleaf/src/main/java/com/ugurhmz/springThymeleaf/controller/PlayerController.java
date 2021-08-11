package com.ugurhmz.springThymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ugurhmz.springThymeleaf.entity.Player;
import com.ugurhmz.springThymeleaf.service.PlayerService;



@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	
	// GET ALL PLAYERS
	@GetMapping("/players")
	public String getPlayer(Model model) {
		List<Player> players = playerService.listAllPlayers();
				
		model.addAttribute("players",players);
		return "players";
	}
	
	
	// GET  PLAYER FORM
	@GetMapping("/players/new")
	public String getNewPlayerForm(Model model) {
		Player player = new Player();
		
		model.addAttribute("player",player);
		return "addNewUser";
	}
	
	
	
	
	//POST NEW PLAYER
	@PostMapping("/players/new")
	public String postNewPlayer(Player player) {
		
		playerService.save(player);
		
		return "redirect:/players";
	}
	
	
	
}
