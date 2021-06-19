package com.godoro.springorm.query;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//spring boot ile Repository kullanimi.. @Query'de sorgu yazilir..
//SpecialRepository'ide implement ederek 2. bir nesne inject etmek zorunda kalmadik 
//Controllerda bu classi inject ederek CrudRepository ve SpecialRepositori tekte kullandik..
public interface SupplierRepository extends CrudRepository<Supplier, Long>, SpecialRepository {

	@Query("select s from Supplier s where s.supplierName = :supplierName")
	List<Supplier> findSuppliersByName(@Param("supplierName") String supplierName);

}
