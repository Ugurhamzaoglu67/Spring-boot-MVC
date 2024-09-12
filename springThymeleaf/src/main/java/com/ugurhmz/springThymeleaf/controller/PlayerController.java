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
import com.ugurhmz.springThymeleaf.service.UserNotFoundException;



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
	public String postNewPlayer(Player player , RedirectAttributes redirectAttributes) {
		
		playerService.save(player);
		redirectAttributes.addFlashAttribute("message","Player has been saved successfully...");
		return "redirect:/players";
	}
	
	
	
	
	
	// UPDATE FORM 
	@GetMapping("/players/edit/{id}")
	public String getUpdateForm(@PathVariable(name="id") Integer playerId,
			Model model, RedirectAttributes redirectAttributes) 
	{
		
		try {
			Player player = playerService.getUser(playerId);
			model.addAttribute("player",player);
			
			return "addNewUser";
			
		} catch(UserNotFoundException ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
			return "redirect:/players";
		}
		
		
	}
		
	
	// DELETE 
	@GetMapping("/players/delete/{id}")
	public String deletePlayer(@PathVariable(name="id") Integer playerId,
			Model model, RedirectAttributes redirectAttributes) 
	{
		try {
			playerService.delete(playerId);
			redirectAttributes.addFlashAttribute("message","The Player ID : "+playerId+" has been deleted successfully");
		} catch(UserNotFoundException ex) {
			redirectAttributes.addFlashAttribute("message",ex.getMessage());
		}
		
		
		return "redirect:/players";
	}
	
	
	
	
	
	
}











