package com.godoro.sprinrest.sports.service;

import java.nio.charset.Charset;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.sprinrest.sports.data.Player;

@RestController
public class StatusResource {

	@GetMapping("status/ok/{id}")
	public ResponseEntity<?> getOk(@PathVariable("id") long playerId) {
		Player player = new Player(playerId, "Orhan Gencebay", 12.34);
		// return new ResponseEntity<>(player, HttpStatus.OK);

		// return ResponseEntity.status(HttpStatus.OK).body(player); // . diye diye
		// istedigimizi daha rahat
		// ekliyebiliyoruz bazi durumlarda kullinailabilir.

		// return ResponseEntity.ok().body(player); // yukardakinin bi kisa yolu

		return ResponseEntity.ok(player); // direk ok icine bodyi yazarakta kisaltilabilir..

	}

	@GetMapping("status/notfound/{id}")
	public ResponseEntity<?> getNotFound(@PathVariable("id") long playerId) {
		Player player = new Player(playerId, "Orhan Gencebay", 12.34);

		if (playerId == 0) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oyuncu bulunamadi");

			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(player); // direk ok icine bodyi yazarakta kisaltilabilir..

	}

	@GetMapping("status/type/{id}")
	public ResponseEntity<?> getType(@PathVariable("id") long playerId) {
		Player player = new Player(playerId, "Orhan Gencebay", 12.34);

		// Media type belirledik.. varsayilani ezer.
		// turkce karakter sorunu icin ayarlanabilir.
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(new MediaType("application", "json", Charset.forName("UTF-8"))).body(player);

	}

}
