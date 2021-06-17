package com.godoro.springapp.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godoro.springapp.business.dto.ProductDto;
import com.godoro.springapp.business.service.ProductService;
import com.godoro.springapp.data.entity.Product;
import com.godoro.springapp.data.repository.ProductRepository;

@Service
public class ProductServiseImpl implements ProductService {

	// Bagimsiz bellekte yasiyan bir nesnedir. (productDto)
	// Controller ile, entity ve veritabanimizin arasinda ki iliskiyi
	// kurar..

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void save(ProductDto productDto) {

		Product product = new Product();
		convertToEntity(productDto, product);
		productRepository.save(product);

	}

	@Override
	public ProductDto find(Long productId) {

		ProductDto productDto = null;
		if (productId != null) {
			Optional<Product> optional = productRepository.findById(productId);

			if (optional.isPresent()) { // bulabildiysen gir..
				productDto = new ProductDto();
				Product product = optional.get();
				convertToDto(product, productDto);
			}
		}
		if (productDto == null) {
			productDto = new ProductDto(0, "", 0.0);
		}

		return productDto;
	}

	@Override
	public List<ProductDto> list() {
		List<ProductDto> productDtos = new ArrayList<>();
		Iterable<Product> products = productRepository.findAll();
		for (Product product : products) {
			ProductDto productDto = new ProductDto();
			convertToDto(product, productDto);
			productDtos.add(productDto);
		}

		return productDtos;
	}

	private void convertToDto(Product product, ProductDto productDto) {

		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setSalesPrice(product.getSalesPrice());

	}

	private void convertToEntity(ProductDto productDto, Product product) {

		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setSalesPrice(productDto.getSalesPrice());

	}

	@Override
	public void delete(long productId) {
		productRepository.deleteById(productId);
	}

}
