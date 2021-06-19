package com.godoro.sprinrest.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.godoro.sprinrest.sports.data.Player;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerController {

	// Servis yolladi burda yani istemci ile aldik..
	// Basit olarak url'den playeri alip syso'da yazdirdik..
	@GetMapping("/client/player/{id}")
	// http://localhost:8080/sports/player/5
	@ResponseBody
	public String getPlayer(@PathVariable("id") long playerId) {

		String url = "http://localhost:8080/sports/player/" + playerId;
		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(url, String.class);
		System.out.println(json);
		return "Json alindi";
	}

	// url'den alip bir Player modelina attik
	@GetMapping("/client/playermodel/{id}")
	// http://localhost:8080/client/playermodel/5
	@ResponseBody
	public String getPlayerModel(@PathVariable("id") long playerId) {

		String url = "http://localhost:8080/sports/player/" + playerId;
		RestTemplate restTemplate = new RestTemplate();
		Player player = restTemplate.getForObject(url, Player.class);
		return "Oyuncu alindi : " + player.getPlayerName() + " " + player.getAverageScore();
	}

	// url'den alip ResponseEntitiy Kullanarak bir Player modeline attik..
	// Normalde kullanilan yontem bu.
	@GetMapping("/client/playermodelResp/{id}")
	// http://localhost:8080/client/playermodelResp/5
	@ResponseBody
	public String getPlayerModelWithResponseEntity(@PathVariable("id") long playerId) {

		String url = "http://localhost:8080/sports/player/" + playerId;
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Player> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				Player.class);
		Player player = responseEntity.getBody();

		return " Oyuncu alindi : " + player.getPlayerName() + " " + player.getAverageScore();
	}

	@GetMapping("/client/players")
	@ResponseBody
	// liste seklinde gonderilmis bir jsonu alip modele attik..
	public String getPlayer() {
		String url = "http://localhost:8080/sports/players";
		RestTemplate restTemplate = new RestTemplate();
		// Uzun bir islem gibi gozukuyor ancak heryerde calisir. hata sonuclari daha
		// dogru doner..
		ResponseEntity<List<Player>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<Player>>() {
				});
		List<Player> playerList = responseEntity.getBody();

		for (Player player : playerList) {
			System.out.println(player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
		}

		return "Json alinmistir: " + playerList;
	}

	@GetMapping("/client/xplayers")
	@ResponseBody
	// liste seklinde gonderilmis bir jsonu alip modele attik..
	public String getPlayerXml() {
		String url = "http://localhost:8080/sports/xplayers";
		RestTemplate restTemplate = new RestTemplate();
		// UzKarsi taraftan hangi turde oldugunu kendisi tarar ve anlar ona gore sonuc
		// doner
		ResponseEntity<List<Player>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<Player>>() {
				});
		List<Player> playerList = responseEntity.getBody();

		for (Player player : playerList) {
			System.out.println(player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
		}

		return "XMl alinmistir: " + playerList;
	}

	@GetMapping("client/send")
	@ResponseBody
	public String sendPlayer(@RequestParam(name = "name") String playerName,
			@RequestParam(name = "score") double averageScore) {

		Player player = new Player(0, playerName, averageScore);
		String url = "http://localhost:8080/sports/player";
		RestTemplate restTemplate = new RestTemplate();
		Player result = restTemplate.postForObject(url, player, Player.class);

		return "Yollandi: " + result.getPlayerId();

	}

	@GetMapping("client/sendRes")
	// http://localhost:8080/cliend/sendRes?name=Muco%20Yusuf&score=12.45
	@ResponseBody
	public String sendPlayerResp(@RequestParam(name = "name") String playerName,
			@RequestParam(name = "score") double averageScore) {

		Player player = new Player(0, playerName, averageScore);
		String url = "http://localhost:8080/sports/player";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Player> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(player),
				Player.class);
		Player result = responseEntity.getBody();
		return "Yollandi: " + result.getPlayerId();

	}

	@GetMapping("client/change")
	// http://localhost:8080/client/change?name=Muco%20Yusuf&score=12.45
	@ResponseBody
	public String changePlayerResp(@RequestParam(name = "name") String playerName,
			@RequestParam(name = "score") double averageScore) {

		Player player = new Player(10, playerName, averageScore);
		String url = "http://localhost:8080/sports/player";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(player),
				Boolean.class);
		boolean updated = responseEntity.getBody();
		return "Koyuldu: " + updated;

	}

	@GetMapping("client/delete{id}")
	@ResponseBody
	public String deletePlayer(@PathVariable("id") long playerId) {
		String url = "http://localhost:8080/sports/player/" + playerId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);

		return "Oyuncu silindi..";

	}

}
