package com.godoro.springcomplex.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.godoro.springcomplex.business.dto.DepartmentSummary;
import com.godoro.springcomplex.business.dto.EmployeeDetail;
import com.godoro.springcomplex.business.dto.EmployeeSummary;
import com.godoro.springcomplex.business.service.DepartmentService;
import com.godoro.springcomplex.business.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(path = { "/employee/edit", "/employee/edit/{id}" })
	public String editEmployee(Model model, @PathVariable(name = "id", required = false) Long employeeId) {
		EmployeeDetail employeeDetail = employeeService.find(employeeId);
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		model.addAttribute("employee", employeeDetail);
		return "/human/EmployeeEdit";
	}

	@PostMapping(path = { "/employee/edit", "/employee/edit/{id}" })
	public String editEmployee(Model model, EmployeeDetail employeeDetail, BindingResult result) {
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		if (result.hasErrors()) {
			result.addError(new ObjectError("employee", "Bicimde bir takim yanlisliklar var!"));
			return "/human/EmployeeEdit";
		}
		employeeService.save(employeeDetail);
		model.addAttribute("message", "Basariyla Saklandi");
		model.addAttribute("employee", employeeDetail);
		return "/human/EmployeeSuccess";
	}

	@GetMapping("/employee/list")
	public String getEmployee(Model model) {
		EmployeeSummary employeeSummary = employeeService.list();
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		model.addAttribute("message", "Calisanlar");
		model.addAttribute("employees", employeeSummary);
		return "human/EmployeeList";
	}

	@PostMapping("/employee/list")
	public String getEmployee(Model model, EmployeeSummary employeeSummary, BindingResult result) {
		System.out.println("employeeSummary.getDepartmentId()  " + employeeSummary.getDepartmentId());
		if (employeeSummary.getDepartmentId() == 0) {
			employeeSummary = employeeService.list();
		} else {
			employeeSummary = employeeService.listByDepartment(employeeSummary.getDepartmentId());
		}

		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		model.addAttribute("message", "Calisanlar");
		model.addAttribute("employees", employeeSummary);
		return "human/EmployeeList";
	}

	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable("id") long employeeId) {
		employeeService.delete(employeeId);
		model.addAttribute("message", "Urun silindi");
		EmployeeSummary employeeSummary = employeeService.list();
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		model.addAttribute("employee", employeeSummary);
		return "human/EmployeeList";
	}
}
