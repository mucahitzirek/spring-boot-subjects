package com.godoro.springbasics.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {

	// http://localhost:8080/parametric/request?myid=123
	@GetMapping("/parametric/request")
	public String getValue(Model model, @RequestParam(name = "myid", required = false, defaultValue = "0") long myId) {
		model.addAttribute("message", "Ozdeslik : " + myId);
		return "parametric/RequestPage";

	}

	// http://localhost:8080/parametric/multiple?mytype=high&myid=123
	@GetMapping("/parametric/multiple")
	public String getMultiple(Model model, @RequestParam(name = "mytype") String myType,
			@RequestParam(name = "myid", required = false, defaultValue = "0") long myId) {

		model.addAttribute("message", "Tur" + myType + "  Ozdeslik : " + myId);
		return "parametric/RequestPage";

	}

}
