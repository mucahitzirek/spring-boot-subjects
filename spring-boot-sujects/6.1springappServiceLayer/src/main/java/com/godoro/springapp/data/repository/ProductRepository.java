package com.godoro.springapp.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.godoro.springapp.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	
	
}
