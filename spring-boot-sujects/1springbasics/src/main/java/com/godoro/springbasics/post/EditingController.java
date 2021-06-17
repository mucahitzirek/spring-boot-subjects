package com.godoro.springbasics.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditingController {

	// http://localhost:8080/editing/employee
	@GetMapping("/editing/employee")
	public String getEmployee(Model model) {
		Employee employee = new Employee(0, "", 0.0);
		model.addAttribute("employee", employee);
		return "post/EmployeeEditor";
	}

	@PostMapping("/editing/employee")
	public String postEmployee(Model model, Employee employee) {

		System.out.println("Saklaniyor " + employee.getEmployeeId() + " " + employee.getEmployeeName() + " "
				+ employee.getMounthSalary());

		model.addAttribute("employee", employee);

		return "post/EmployeeEditor";
	}

}
