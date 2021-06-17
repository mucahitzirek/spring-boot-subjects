package com.godoro.springapp.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.godoro.springapp.data.entity.Product;

/*
 * Veri Tabani islemleri icin springin sagladigi classi kullaniyoruz
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

}
