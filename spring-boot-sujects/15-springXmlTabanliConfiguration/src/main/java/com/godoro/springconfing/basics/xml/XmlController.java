package com.godoro.springconfing.basics.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.springconfing.basics.bean.MyAgent;
import com.godoro.springconfing.basics.bean.MyBean;
import com.godoro.springconfing.basics.bean.MySpec;

@Controller
public class XmlController {

	@GetMapping("xml/bean")
	@ResponseBody
	public String getBean() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springBeans.xml");

		MyBean myBean = (MyBean) context.getBean("myBean");
		context.close();
		return " " + myBean;
	}

	@GetMapping("xml/reference")
	@ResponseBody
	public String getReference() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springBeans.xml");

		MyAgent myAgent = (MyAgent) context.getBean("myAgent");
		context.close();
		return " Basvuru : " + myAgent.getAgentName() + " " + myAgent.getMyBean();
	}

	@GetMapping("xml/myspec")
	@ResponseBody
	public String MySpec() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springBeans.xml");

		MySpec MySpec = (MySpec) context.getBean("mySpec");
		context.close();
		return " Evirtme >  " + MySpec.myMethod(" Girdi ");
	}

}
