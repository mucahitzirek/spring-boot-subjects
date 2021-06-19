package com.godoro.springconfing.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.springconfing.basics.bean.MyBean;

@Controller
public class SourceController {

	@Autowired
	private MyBean myBean;

	@GetMapping("source/bean")
	@ResponseBody
	public String getBean() {
		return "Cekirdek : " + myBean;
	}

}
