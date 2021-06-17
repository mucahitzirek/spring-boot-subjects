package com.godoro.springclient.data.client.impl;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.godoro.springclient.business.dto.ProductDto;
import com.godoro.springclient.data.client.ProductClient;

@Component
public class ProductClientImpl implements ProductClient {

	RestTemplate restTemplate = new RestTemplate();
	public final static String URL_BASE = "http://localhost:8080/rest/product";

	/*
	 * id'ye gore json'dan veri aldik..
	 */
	public ProductDto getProduct(long productId) {

		String url = URL_BASE + "/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);

		return productDto;
	}

	/*
	 * Butun json listesini aldik
	 */
	public List<ProductDto> getProducts() {
		String url = URL_BASE + "/list";

		ResponseEntity<List<ProductDto>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<ProductDto>>() {
				});
		List<ProductDto> playerList = responseEntity.getBody();
		return playerList;
	}

	public ProductDto postPlayer(ProductDto productDto) {
		String url = URL_BASE;
		ProductDto result = restTemplate.postForObject(url, productDto, ProductDto.class);
		return result;
	}

	public void putPlayer(ProductDto productDto) {
		String url = URL_BASE;
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(productDto), Void.class);
	}

	public void deletePlayer(long productId) {
		String url = URL_BASE + "/" + productId;
		restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
	}

}
