package com.godoro.springcomplex.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.springcomplex.business.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/department/generate/{name}")
	@ResponseBody
	public String generadeDepartment(@PathVariable(name = "name") String departmentName) {

		long departmentId = departmentService.generateDepartment(departmentName);

		return "Kusaldi " + departmentId;
	}

}
