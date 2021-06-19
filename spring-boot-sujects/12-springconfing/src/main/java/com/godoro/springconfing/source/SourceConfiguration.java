package com.godoro.springconfing.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.godoro.springconfing.basics.bean.MyBean;

@Configuration
public class SourceConfiguration {

	// burada konfigure edilsin,
	// bana lazim oldugu zaman hazir sekilde controllerda kullanayim
	// en basitiyle Configuration(beanlari bu classta tarar) ve
	// bean ise inject edildiginde kim veriyorsa ondan verileri getirir.
	@Bean
	public MyBean myBean() {

		MyBean myBean = new MyBean();
		myBean.setMyLong(300);
		myBean.setMyDouble(3.45);
		myBean.setMyString("Mucahit");

		return myBean;
	}

}
