package com.godoro.springsecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {

	@GetMapping("login")
	public String getLogin(@RequestParam(name = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("message", "Kimlik bilgileri yanlis");
		} else {
			model.addAttribute("message", "Giris yapiniz");
		}
		return "custom/LoginPage";
	}

	@GetMapping("logout")
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // sistemde giris
																								// yapmisi bulduk...
		if (authentication != null) {
			SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
			logoutHandler.logout(request, response, authentication);
		}
		return "custom/LogoutPage";
	}

	@GetMapping("currentroles")
	@ResponseBody
	public String getCurrent(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // sistemde giris
		StringBuilder builder = new StringBuilder();
		if (authentication != null) {
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				builder.append(authority.getAuthority()).append(" ");
			}
			return "Yetkililer " + builder.toString();
		}
		return "Giris yapilmamis";
	}
}
