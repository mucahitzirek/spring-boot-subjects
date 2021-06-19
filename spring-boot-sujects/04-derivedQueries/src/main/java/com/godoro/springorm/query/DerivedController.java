package com.godoro.springorm.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DerivedController {

	@Autowired
	private DerivedQueries derivedController;

	@GetMapping("/supplier/findbynamestarts/{name}")
	@ResponseBody
	public String findSupplierByName(@PathVariable(name = "name") String supplierName) {

		Iterable<Supplier> suppliers = derivedController.findBySupplierNameEndsWith(supplierName);
		int count = 0;
		double grandDebit = 0;
		for (Supplier supplier : suppliers) {
			grandDebit += supplier.getTotalDebit();
			count++;
			System.out.println(supplier.getSupplierName());
		}
		return "Alimcilar bulundu " + count + " toplam alacaklari " + grandDebit;
		// Alimcilar kusaldi 4 toplam alacaklari 2150.0
	}

}
