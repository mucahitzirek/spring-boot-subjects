package com.godoro.springbasics.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidateController {

	@GetMapping("/validating/employee")
	public String getEmployee(Model model) {
		Employee employee = new Employee(0, "", 0.0);
		model.addAttribute("employee", employee);
		return "post/EmployeeForm";
	}

	@PostMapping("/validating/employee")
	public String postEmployee(Model model, Employee employee, BindingResult result) {

		model.addAttribute("employee", employee);
		if (result.hasErrors()) {

			System.out.println("Hatali Saklama " + employee.getEmployeeId() + " " + employee.getEmployeeName() + " "
					+ employee.getMounthSalary());

			return "post/EmployeeForm";
		}

		if (employee.getEmployeeName().length() < 3) {
			// employee Tabloya ozgu oldu ..
			result.addError(new ObjectError("employee", "Bicimde bir takim yanlisliklar var!"));
			// employeeName'e ozgu oldu..
			result.addError(new FieldError("employee", "employeeName", "Calisan adi en az 3 ozyapili olmali!"));
			return "post/EmployeeForm";
		}

		model.addAttribute("message", "Basariyla Saklandi");
		return "post/EmployeeSuccess";
	}

}
