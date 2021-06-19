package com.godoro.sprinrest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TransferController {

	// istemci karsi tarafa baslik yolladi
	@GetMapping("/client/header")
	@ResponseBody
	public String getPlayer() {
		String url = "http://localhost:8080/transfer/header";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.add("input", "Godoro");
		HttpEntity<String> entity = new HttpEntity<String>("Govde", headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		return "Baslik gonderildi: " + response.getBody();
	}

	@GetMapping("/client/cookie")
	@ResponseBody
	public String getCookie() {
		String url = "http://localhost:8080/transfer/cookie";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.COOKIE, "input=Godoro");
		HttpEntity<String> entity = new HttpEntity<String>("Govde", headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		return "Baslik gonderildi: " + response.getBody();
	}

	@GetMapping("/client/setheader")
	@ResponseBody
	public String setHeader() {
		String url = "http://localhost:8080/transfer/setheader ";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class);
		String input = response.getHeaders().getFirst("input");

		return "Baslik alindi: " + response.getBody() + " Baslik " + input;
	}

	@GetMapping("/client/setcookie")
	@ResponseBody
	public String setCookie() {
		String url = "http://localhost:8080/transfer/setcookie";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class);
		String input = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);

		return "Cerez alindi: " + response.getBody() + " Cerez " + input;
	}

}
