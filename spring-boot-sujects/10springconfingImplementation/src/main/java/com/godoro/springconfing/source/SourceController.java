package com.godoro.springconfing.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.springconfing.basics.bean.MyAgent;
import com.godoro.springconfing.basics.bean.MyBean;

@Controller
public class SourceController {

	@Autowired
	private MyBean myBean;

	@Autowired
	private MyBean anotherBean;

	@Autowired
	private MyAgent myAgent;

	@GetMapping("source/bean")
	@ResponseBody
	public String getBean() {
		return "Cekirdek : " + myBean;
	}

	@GetMapping("source/scope")
	@ResponseBody
	public String getScope() {

		return "Kapsam : " + myBean.hashCode() + " ==?  " + anotherBean.hashCode();
	}

	@GetMapping("source/reference")
	@ResponseBody
	public String getReference() {

		return "Basvuru : " + myAgent.getAgentName() + " -  " + myAgent.getMyBean() + " / " + myBean.hashCode()
				+ " ==? " + myAgent.getMyBean().hashCode();
	}
}
