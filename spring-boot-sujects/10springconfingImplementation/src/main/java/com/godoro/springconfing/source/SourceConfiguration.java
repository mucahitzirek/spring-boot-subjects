package com.godoro.springconfing.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.godoro.springconfing.basics.bean.MyAgent;
import com.godoro.springconfing.basics.bean.MyBean;

@Configuration
public class SourceConfiguration {

	// tersi soylenmedikce tek sefer olusturur her seferinde o kullanilir..
	@Bean(initMethod = "initializeBean", destroyMethod = "finalizeBean")
	@Scope("prototype")
	// Scope her durunm icin ayri bir tane olusturur..
	public MyBean myBean() {

		MyBean myBean = new MyBean();
		myBean.setMyLong(300);
		myBean.setMyDouble(3.45);
		myBean.setMyString("Mucahit");

		return myBean;
	}

	@Bean
	public MyAgent myagent() {

		MyAgent myAgent = new MyAgent();
		myAgent.setAgentName("Acente");
		// MyBean Scope'prototype secilirse burada myBean yeniden olusturulur.
		// prototype yazilmazsa tekrar yeniden olusturmaz..
		myAgent.setMyBean(myBean());

		return myAgent;
	}

}
