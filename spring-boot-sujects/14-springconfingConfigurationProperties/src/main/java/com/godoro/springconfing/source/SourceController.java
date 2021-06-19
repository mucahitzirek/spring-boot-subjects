package com.godoro.springconfing.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SourceController {

	@Autowired
	private CommerceProperties commerceProperties;

	@GetMapping("source/properties")
	@ResponseBody
	public String getProperties() {

		return "Evirtme > " + commerceProperties.getEmailAddress() + "  Banka Adi :  "
				+ commerceProperties.getBank().getName() + "  Banka odeme zamani :  "
				+ commerceProperties.getBank().getPaymentTime();
	}
}
