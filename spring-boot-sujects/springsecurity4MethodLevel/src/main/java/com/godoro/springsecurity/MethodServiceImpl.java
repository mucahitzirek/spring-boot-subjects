package com.godoro.springsecurity;

import org.springframework.stereotype.Service;

@Service
public class MethodServiceImpl implements MethodicService{

	public String getAdminValue() {
		return "Yonetici Degeri";
	}

}
