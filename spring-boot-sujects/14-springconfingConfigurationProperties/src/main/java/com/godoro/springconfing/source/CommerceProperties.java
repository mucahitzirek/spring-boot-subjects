package com.godoro.springconfing.source;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "commerce")
@Configuration // bunu yaparak SourceConfigure classimda @Bean olarak tanimlamaya gerek
				// kalmadi..
@Validated
public class CommerceProperties {

	private String site = "www.godoro.com";

	@Email // email icin valideate islemlerini yapar
	private String emailAddress;

	@Min(1)
	@Max(14)
	private int returnDays;

	private Bank bank;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getReturnDays() {
		return returnDays;
	}

	public void setReturnDays(int returnDays) {
		this.returnDays = returnDays;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
