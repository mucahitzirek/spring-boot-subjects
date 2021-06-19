package com.godoro.springorm.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParticularController {

	@Autowired
	private ParticularRepository particularRepository;

	// http://localhost:8080/supplier/page
	@GetMapping("/supplier/page")
	@ResponseBody
	public String findPageSuppliers() {

		Page<Supplier> suppliers = particularRepository.findAll(PageRequest.of(3, 15));
		int count = 0;
		double grandDebit = 0;
		for (Supplier supplier : suppliers) {
			System.out.println(supplier.getSupplierName());
			grandDebit += supplier.getTotalDebit();
			count++;
			System.out.println(supplier);
		}
		return "Alimcilar kusaldi " + count + " toplam alacaklari " + grandDebit;

	}

	@GetMapping("/supplier/sort")
	@ResponseBody
	public String findSortedSuppliers() {

		Iterable<Supplier> suppliers = particularRepository.findAll(Sort.by("supplierName"));
		int count = 0;
		double grandDebit = 0;
		for (Supplier supplier : suppliers) {
			System.out.println(supplier.getSupplierName());
			grandDebit += supplier.getTotalDebit();
			count++;
			System.out.println(supplier);
		}
		return "Alimcilar kusaldi " + count + " toplam alacaklari " + grandDebit;

	}

}
