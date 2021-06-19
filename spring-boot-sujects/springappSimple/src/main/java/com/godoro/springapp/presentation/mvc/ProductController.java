package com.godoro.springapp.presentation.mvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.godoro.springapp.data.entity.Product;
import com.godoro.springapp.data.repository.ProductRepository;

//springappSimple ->
@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping(path = { "/product/edit", "/product/edit/{id}" })
	public String editProduct(Model model, @PathVariable(name = "id", required = false) Long productId) {
		Product product;
		if (productId == null) {
			product = new Product(0, "", 0.0);
		} else {
			Optional<Product> optional = productRepository.findById(productId);
			if (optional.isPresent()) {
				product = optional.get();
			} else {
				product = new Product(0, "", 0.0);
			}
		}
		model.addAttribute("product", product);
		return "/inventory/ProductEdit";
	}

	@PostMapping(path = { "/product/edit", "/product/edit/{id}" })
	public String insertProduct(Model model, Product product, BindingResult result) {
		productRepository.save(product);

		if (result.hasErrors()) {
			result.addError(new ObjectError("product", "Bicimde bir takim yanlisliklar var!"));
			return "/inventory/ProductEdit";
		}

		model.addAttribute("message", "Basariyla Saklandi");
		return "/inventory/ProductSuccess";
	}

	@GetMapping("/product/list")
	public String getProduct(Model model) {
		Iterable<Product> products = productRepository.findAll();
		model.addAttribute("message", "Urunler");
		model.addAttribute("products", products);
		return "inventory/ProductList";
	}

	@GetMapping("/product/delete/{id}")
	public String deleteProduct(Model model, @PathVariable("id") long productId) {

		productRepository.deleteById(productId);
		model.addAttribute("message", "Urun silindi");
		Iterable<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "inventory/ProductList";
	}
}
