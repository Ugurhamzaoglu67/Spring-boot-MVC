package com.ugurhmz.springThymeleaf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Player_TABLE")
public class Player {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer playerId;
	private String playerName;
	private double playerValue;
	
	
	
	public Player() {
		
	}


	public Player(Integer playerId, String playerName, double playerValue) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerValue = playerValue;
	}



	public Integer getPlayerId() {
		return playerId;
	}



	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}



	public String getPlayerName() {
		return playerName;
	}



	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}



	public double getPlayerValue() {
		return playerValue;
	}



	public void setPlayerValue(double playerValue) {
		this.playerValue = playerValue;
	}
	
	
	
	
	
}
