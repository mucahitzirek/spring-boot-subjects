package com.godoro.springconfing.basics.bean;

public class MyBean {

	private long myLong;

	private String myString;

	private double myDouble;

	public long getMyLong() {
		return myLong;
	}

	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	public double getMyDouble() {
		return myDouble;
	}

	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}

	public void initializeBean() {
		System.out.println("Ilklendiriliyor initializeBean");
	}

	public void finalizeBean() {
		System.out.println("sonlandiriliyor finalizeBean");
	}

	@Override
	public String toString() {
		return "MyBean [myLong=" + myLong + ", myString=" + myString + ", myDouble=" + myDouble + "]";
	}

}
