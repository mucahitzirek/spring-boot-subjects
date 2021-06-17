package com.godoro.springorm.query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long suppilerId;
	private String supplierName;
	private double totalDebit;

	public Supplier() {

	}

	public Supplier(long suppilerId, String supplierName, double totalDebit) {
		this.suppilerId = suppilerId;
		this.supplierName = supplierName;
		this.totalDebit = totalDebit;
	}

	public long getSuppilerId() {
		return suppilerId;
	}

	public void setSuppilerId(long suppilerId) {
		this.suppilerId = suppilerId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public double getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(double totalDebit) {
		this.totalDebit = totalDebit;
	}

	@Override
	public String toString() {
		return "Supplier [suppilerId=" + suppilerId + ", supplierName=" + supplierName + ", totalDebit=" + totalDebit
				+ "]";
	}

}
