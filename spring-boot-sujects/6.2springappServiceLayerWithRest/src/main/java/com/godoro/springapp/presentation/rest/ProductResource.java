package com.godoro.springapp.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.springapp.business.dto.ProductDto;
import com.godoro.springapp.business.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//springappSimple -> springappServiceLayer -> springappServiceLayerWithRest

@RestController
public class ProductResource {

	@Autowired
	private ProductService productService;

	/*
	 * id'ye gore json olarak geri dondurduk..
	 */
	@GetMapping("rest/product/{id}")
	public ProductDto getProduct(@PathVariable("id") long productId) {
		ProductDto productDto = productService.find(productId);
		return productDto;
	}

	/*
	 * Tum listemizi json olarak geri dondurduk
	 */
	@GetMapping("rest/product/list")
	public List<ProductDto> getProducts() {
		List<ProductDto> productDto = productService.list();
		return productDto;
	}

	/*
	 * Bir kayit eklettirdik
	 */
	@PostMapping("rest/product")
	public ProductDto postProduct(@RequestBody ProductDto productDto) {
		productService.save(productDto);
		return productDto;
	}

	@PutMapping("rest/product")
	public void putProduct(@RequestBody ProductDto productDto) {
		productService.save(productDto);
	}

	@DeleteMapping("rest/product/{id}")
	public void deleteProduct(@PathVariable("id") long productId) {
		productService.delete(productId);
	}
}
