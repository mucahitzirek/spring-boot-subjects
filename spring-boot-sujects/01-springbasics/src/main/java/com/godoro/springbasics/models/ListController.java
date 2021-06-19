package com.godoro.springbasics.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

	@GetMapping("/models/list")
	public String getMessage(Model model) {

		List<Product> products = new ArrayList<>();

		products.add(new Product(301, "Cep Telefonu", 1300));
		products.add(new Product(302, "Masaustu bilgisayar", 4500));
		products.add(new Product(303, "Dizustu Bilgisayar", 6200));

		model.addAttribute("products", products);

		return "models/ListPage";

	}

}