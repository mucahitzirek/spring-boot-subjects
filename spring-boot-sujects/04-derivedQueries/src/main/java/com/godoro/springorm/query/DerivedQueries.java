package com.godoro.springorm.query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DerivedQueries extends JpaRepository<Supplier, Long> {

	// Burada onemli olan fonksiyon isimlerini kuralina gore yazmak!
	// findBy ile baslar entity classi ismi yazilir ve sorgu turune uygun anahtar
	// kelimeler yazilir (Name) isme gore arama yapmak mesela
	// select s from Supplier s where s.supplierName =:supplierName
	// Sorgusunu JpaRepository extendi ile kendi kendine sorguyu olusturur;;;
	List<Supplier> findBySupplierName(String supplierName);

	// yazilan < > = % gibi opratorleri bile bu sekilde belirte biliriz burda Like
	// ile % operatorunu belirtmis olduk
	List<Supplier> findBySupplierNameLike(String supplierNamePattern);

	List<Supplier> findBySupplierNameStartsWith(String supplierNameStart);

	List<Supplier> findBySupplierNameEndsWith(String supplierNameEnd);

	List<Supplier> findByTotalDebitGreaterThanEqual(double totalDebit);

	List<Supplier> findByTotalDebitBetween(double totalDebitMin, double totalDebitMax);

	// Sonu girilen ile biten, yada verdigimden totaldebit girilenden daha az
	// olanlarin sorgusunu yazar
	List<Supplier> findBySupplierNameEndsWithOrTotalDebitLessThan(double supplierNameEnd, double totalDebitMax);
}
