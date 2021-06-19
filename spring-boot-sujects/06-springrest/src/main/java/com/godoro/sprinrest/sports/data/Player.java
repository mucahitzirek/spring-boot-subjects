package com.godoro.sprinrest.sports.data;

public class Player {

	private long playerId;
	private String playerName;
	private double averageScore;

	public Player() {

	}

	public Player(long playerId, String playerName, double averageScore) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.averageScore = averageScore;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", averageScore=" + averageScore + "]";
	}
	

}
