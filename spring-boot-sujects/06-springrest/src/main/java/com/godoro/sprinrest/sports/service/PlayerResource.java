package com.godoro.sprinrest.sports.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.sprinrest.sports.data.Player;

@RestController
public class PlayerResource {

	// @GetMapping(value = "/sports/player", produces =
	// MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/sports/player/{id}") // yukaridaki ile aynidir default olarak json modeli gonderir..
	public Player getPlayer(@PathVariable("id") long playerId) {
		Player player = new Player(playerId, "Orhan Gencebay", 12.24);
		return player;
	}

	@GetMapping(value = "/sports/xplayers", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Player> getPlayersXMl() {
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player(201, "Orhan Gencebay", 12.24));
		playerList.add(new Player(202, "Ferdi Tayfur", 12.24));
		playerList.add(new Player(203, "Selami Sahin", 12.24));
		return playerList;
	}

	@GetMapping("/sports/players")
	public List<Player> getPlayers() {
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player(201, "Orhan Gencebay", 12.24));
		playerList.add(new Player(202, "Ferdi Tayfur", 12.24));
		playerList.add(new Player(203, "Selami Sahin", 12.24));
		return playerList;
	}

	@PostMapping("/sports/player")
	public Player postPlayer(@RequestBody Player player) {
		System.out.println(player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());

		player.setPlayerId(804);
		return player;

	}

	@PutMapping("/sports/playerput")
	public boolean putPlayer(@RequestBody Player player) {

		System.out.println("Guncelleniyor : " + player.getPlayerId() + " " + player.getPlayerName() + " "
				+ player.getAverageScore());

		player.setPlayerId(804);
		return true;

	}

	@DeleteMapping("/sports/player/{id}")
	public boolean deletePlayer(@PathVariable("id") long playerId) {
		System.out.println("Siliniyor " + playerId);
		return true;

	}

}
