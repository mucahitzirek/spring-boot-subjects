package com.godoro.springorm.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupplierController {

	@Autowired
	private SupplierRepository supplierRepository;

	// @Autowired
	// private SpecialRepository specialRepository;

	@GetMapping("/supplier/generate")
	@ResponseBody
	public String generatedSuppliers() {
		for (int i = 0; i < 100; i++) {
			Supplier supplier = new Supplier(0, "Satimci " + (i + 1), 500 + 25 * i);
			supplierRepository.save(supplier);
		}
		return "Alimcilar kusaldi" + 100;
	}

	// http://localhost:8080/supplier/findall
	@GetMapping("/supplier/findall")
	@ResponseBody
	public String findAllSuppliers() {

		Iterable<Supplier> suppliers = supplierRepository.findAll();
		int count = 0;
		double grandDebit = 0;
		for (Supplier supplier : suppliers) {
			grandDebit += supplier.getTotalDebit();
			count++;
			System.out.println(supplier);
		}
		return "Alimcilar kusaldi " + count + " toplam alacaklari " + grandDebit;

	}

	// http://localhost:8080/supplier/findbyname/Satimci%201
	@GetMapping("/supplier/findbyname/{name}")
	@ResponseBody
	public String findSupplierByName(@PathVariable(name = "name") String supplierName) {

		Iterable<Supplier> suppliers = supplierRepository.findSuppliersByName(supplierName);
		int count = 0;
		double grandDebit = 0;
		for (Supplier supplier : suppliers) {
			grandDebit += supplier.getTotalDebit();
			count++;
			// System.out.println(supplier);
		}
		return "Alimcilar kusaldi " + count + " toplam alacaklari " + grandDebit;
		// Alimcilar kusaldi 4 toplam alacaklari 2150.0
	}

	@GetMapping("/supplier/findbymindebit/{debit}")
	@ResponseBody
	public String findSupplierTotalDebitMin(@PathVariable(name = "debit") double totalDebitName) {

		Iterable<Supplier> suppliers = supplierRepository.findSupplierTotalDebitMin(totalDebitName);
		int count = 0;
		double grandDebit = 0;
		for (Supplier supplier : suppliers) {
			grandDebit += supplier.getTotalDebit();
			count++;
			System.out.println(supplier.getSupplierName());
		}
		return "COk alacakli limcilar " + count + " toplam alacaklari " + grandDebit;
	}

}
