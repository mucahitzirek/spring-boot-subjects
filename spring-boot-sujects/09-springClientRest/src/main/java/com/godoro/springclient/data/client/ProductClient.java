package com.godoro.springclient.data.client;

import java.util.List;

import com.godoro.springclient.business.dto.ProductDto;

public interface ProductClient {
	
	public ProductDto getProduct(long productId);

	public List<ProductDto> getProducts();

	public ProductDto postPlayer(ProductDto productDto);

	public void putPlayer(ProductDto productDto);

	public void deletePlayer(long productId);
}
