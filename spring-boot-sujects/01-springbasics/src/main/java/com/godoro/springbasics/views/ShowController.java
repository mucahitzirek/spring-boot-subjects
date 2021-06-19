package com.godoro.springbasics.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {

	@GetMapping("/show")
	public String getShow() {
		return "ShowPage.jsp";
	}

	@GetMapping("/indirect")
	public String getIndirect() {
		return "IndirectPage"; // application.properties'te yazdiklarimiz sayesinde klasor yolunu bu kadar kisa
								// verdik .jsp bile koymadik
	}

	@GetMapping("/below/under")
	public String getUnder() {
		return "below/UnderPage";
	}
}
