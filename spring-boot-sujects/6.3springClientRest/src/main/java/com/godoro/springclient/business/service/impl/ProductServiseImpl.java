package com.godoro.springclient.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.godoro.springclient.business.dto.ProductDto;
import com.godoro.springclient.business.service.ProductService;
import com.godoro.springclient.data.client.ProductClient;

@Service
public class ProductServiseImpl implements ProductService {

	@Autowired
	private ProductClient productClient;

	@Override
	public void save(ProductDto productDto) {
		if (productDto.getProductId() == 0) {
			productClient.postPlayer(productDto);
		} else {
			productClient.putPlayer(productDto);
		}

	}

	@Override
	public ProductDto find(Long productId) {
		ProductDto productDto = null;
		if (productId != null) {
			productDto = productClient.getProduct(productId);
		} else {
			productDto = new ProductDto(0, "", 0.0);
		}
		return productDto;

	}

	@Override
	public List<ProductDto> list() {
		return productClient.getProducts();
	}

	@Override
	public void delete(long productId) {
		productClient.deletePlayer(productId);
	}

}
