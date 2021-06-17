package com.godoro.springapp.business.service;

import java.util.List;

import com.godoro.springapp.business.dto.ProductDto;

public interface ProductService {

	public void save(ProductDto productDto);

	public ProductDto find(Long productId);

	public List<ProductDto> list();

	public void delete(long productId);
}
