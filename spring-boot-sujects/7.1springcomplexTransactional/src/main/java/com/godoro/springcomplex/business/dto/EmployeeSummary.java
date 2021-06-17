package com.godoro.springcomplex.business.dto;

import java.util.List;

public class EmployeeSummary {

	private int employeeCount;

	private long departmentId;

	private String departmentName;

	private List<EmployeeDetail> employeeDetailList;

	public List<EmployeeDetail> getEmployeeDetailList() {
		return employeeDetailList;
	}

	public void setEmployeeDetailList(List<EmployeeDetail> employeeDetailList) {
		this.employeeDetailList = employeeDetailList;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
