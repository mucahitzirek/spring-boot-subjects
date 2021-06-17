package com.godoro.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MethodicController {

	@Autowired
	private MethodicService methodicService;

	@GetMapping("/method/admin")
	@ResponseBody
	public String getAdmin() {

		return methodicService.getAdminValue();

	}

}
