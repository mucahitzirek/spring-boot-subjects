package com.godoro.springapp.presentation.mvc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.godoro.springapp.business.dto.ProductDto;
import com.godoro.springapp.business.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = { "/product/edit", "/product/edit/{id}" })
	public String editProduct(Model model, @PathVariable(name = "id", required = false) Long productId) {

		ProductDto product = productService.find(productId);
		model.addAttribute("product", product);
		return "/inventory/ProductEdit";
	}

	@PostMapping(path = { "/product/edit", "/product/edit/{id}" })
	public String insertProduct(Model model, ProductDto product, BindingResult result) {
		productService.save(product);
		if (result.hasErrors()) {
			result.addError(new ObjectError("product", "Bicimde bir takim yanlisliklar var!"));
			return "/inventory/ProductEdit";
		}
		model.addAttribute("message", "Basariyla Saklandi");
		model.addAttribute("product", product);
		return "/inventory/ProductSuccess";
	}

	@GetMapping("/product/list")
	public String getProduct(Model model) {
		List<ProductDto> productDtos = productService.list();
		model.addAttribute("message", "Urunler");
		model.addAttribute("products", productDtos);
		return "inventory/ProductList";
	}

	@GetMapping("/product/delete/{id}")
	public String deleteProduct(Model model, @PathVariable("id") long productId) {
		productService.delete(productId);
		model.addAttribute("message", "Urun silindi");
		List<ProductDto> productDtos = productService.list();
		model.addAttribute("products", productDtos);
		return "inventory/ProductList";
	}
}
