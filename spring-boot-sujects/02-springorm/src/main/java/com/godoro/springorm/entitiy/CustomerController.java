package com.godoro.springorm.entitiy;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customer/persist")
	@ResponseBody
	public String persistCustomer(@RequestParam(name = "name") String customerName,
			@RequestParam(name = "credit") double totalCredit) {

		Customer customer = new Customer(0, customerName, totalCredit);
		customerRepository.save(customer);

		return "Varlik direldi : " + customer.getCustomerId();

	}

	// http://localhost:8080/customer/find/5
	@GetMapping("/customer/find/{id}")
	@ResponseBody
	public String findCustomer(@PathVariable(name = "id") long customerId) {

		// Optional varsa kullan yoksa kullanma..
		Optional<Customer> optional = customerRepository.findById(customerId);

		if (optional.isPresent()) {
			Customer customer = optional.get();
			return "Varlik direldi : " + customer.getCustomerName() + " " + " borc :" + customer.getTotalCredit();
		} else {
			return "Varlik bulunamadi " + customerId;
		}
	}

	// http://localhost:8080/customer/merge/5?name=Muco&credit=123
	@GetMapping("/customer/merge/{id}")
	@ResponseBody
	public String mergeCustomer(@PathVariable(name = "id") long customerId,
			@RequestParam(name = "name") String customerName, @RequestParam(name = "credit") double totalCredit) {

		// Once buluyoruz
		Optional<Customer> optional = customerRepository.findById(customerId);

		if (optional.isPresent()) {
			Customer customer = optional.get();
			customer.setCustomerName(customerName);
			customer.setTotalCredit(totalCredit);
			// Sonra ekliyoruz..
			customerRepository.save(customer);

			return "Varlik Kaynastirildi : " + customer.getCustomerId();
		} else {
			return "Varlik bulunamadi " + customerId;
		}

	}

	// http://localhost:8080/customer/remove/1
	@GetMapping("/customer/remove/{id}")
	@ResponseBody
	public String removeCustomer(@PathVariable(name = "id") long customerId) {

		customerRepository.deleteById(customerId);
		return "Varlik silindi : " + customerId;
	}

}
