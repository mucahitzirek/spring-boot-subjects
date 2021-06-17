package com.godoro.sprinrest.sports.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferResource {

	@GetMapping("transfer/header")
	public ResponseEntity<?> getHeader(@RequestHeader(value = "input", defaultValue = "varsayilan") String input) {

		String output = "Giren > " + input;
		return ResponseEntity.ok(output);
	}

	@GetMapping("transfer/cookie")
	public ResponseEntity<?> getCookie(@CookieValue(value = "input") String input) {

		String output = "Giren > " + input;
		return ResponseEntity.ok(output);
	}

	@GetMapping("transfer/setheader")
	public ResponseEntity<?> setHeader() {

		return ResponseEntity.ok().header("input", "Godoro").body("baslik gonderildi");
	}

	@GetMapping("transfer/setcookie")
	public ResponseEntity<?> setCookie() {

		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, "Godoro").body("Cerez gonderildi");
	}

}
