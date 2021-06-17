package com.godoro.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutherizationController {

	@GetMapping("high")
	public String getHight() {

		return "high/HighPage";
	}

	@GetMapping("low")
	public String getLow() {

		return "low/LowPage";
	}

}
