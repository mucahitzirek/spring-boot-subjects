package com.godoro.springconfing.basics.bean;

public class MySpecImpl implements MySpec {

	@Override
	public String myMethod(String input) {

		return "Gerceklestirim" + input;
	}

}
