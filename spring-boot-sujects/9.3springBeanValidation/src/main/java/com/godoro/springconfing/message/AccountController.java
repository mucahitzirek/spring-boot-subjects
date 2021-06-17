package com.godoro.springconfing.message;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//springappSimple ->
@Controller
public class AccountController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/account/edit")
	public String editaccount(Model model) {
		Account account = new Account(0, "", 0.0);
		model.addAttribute("message", messageSource.getMessage("account.forum.fill", null, null));
		model.addAttribute("account", account);
		return "/ledger/AccountEdit";
	}

	@PostMapping(path = { "/account/edit", "/account/edit/{id}" })
	public String insertaccount(Model model, @Valid Account account, BindingResult result) {
		if (result.hasErrors()) {
			result.addError(new ObjectError("account", "Bicimde bir takim yanlisliklar var!"));
			return "/ledger/AccountEdit";
		}
		model.addAttribute("account", account);
		model.addAttribute("message", messageSource.getMessage("account.form.saved", null, null));
		return "/ledger/AccountEdit";
	}

}
