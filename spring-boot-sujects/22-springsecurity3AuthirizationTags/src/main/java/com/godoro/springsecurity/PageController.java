package com.godoro.springsecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping(path = { "/", "/home" })
	public String getHome() {
		return "public/HomePage";
	}

	@GetMapping("/welcome")
	public String getWelcome(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = "";
		if (authentication != null) {
			userName = authentication.getName();
		}
		model.addAttribute("userName", userName);
		return "private/WelcomePage";
	}

}
