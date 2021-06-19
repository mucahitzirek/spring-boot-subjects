package com.godoro.springbasics.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParametricController {

	@GetMapping("/parametric/value/{myid}")
	public String getValue(Model model, @PathVariable(name = "myid") long myId) {
		model.addAttribute("message", "Ozdeslik : " + myId);
		return "parametric/VariablePage";

	}
	
	// http://localhost:8080/plural/high/123
	@GetMapping("/parametric/plural/{mytype}/{myid}")
	public String getMultiple(Model model, @RequestParam(name = "mytype") String myType,
			@RequestParam(name = "myid", required = false, defaultValue = "0") long myId) {

		model.addAttribute("message", "Tur" + myType + "  Ozdeslik : " + myId);
		return "parametric/RequestPage";

	}
	

	@GetMapping({ "/parametric/optional/{myid}", "/parametric/optional/" })
	public String getoptional(Model model, @PathVariable(name = "myid", required = false) Long myId) {

		if (myId != null) {
			model.addAttribute("message", "Ozdeslik : " + myId);
		} else {
			model.addAttribute("message", "Ozdeslik : " + 0);
		}

		return "parametric/VariablePage";

	}

}
